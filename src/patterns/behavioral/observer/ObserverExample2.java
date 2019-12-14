package patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

interface Notifier {
    public void addObserver (IndicatorsObserver obs);
    public void removeObserver (IndicatorsObserver obs);
    public void notifyObserver();
}

class CentralComp implements Notifier {
    private List observers;    // список наблюдателей
    private int speed;      // скорость
    private int rpm;        // обороты двигателя
    private int oilPressure;    // давление масла
    
    public CentralComp(){
        observers = new ArrayList();
    }
    
    // добавить слушателя
    public void addObserver(IndicatorsObserver obs) {
        observers.add(obs);
    }

    // удалить слушателя
    public void removeObserver(IndicatorsObserver obs) {
        int i = observers.indexOf(obs);
        if (i >= 0){
            observers.remove(i);
        }
    }

    // уведомить слушателей
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++){
        	IndicatorsObserver obs = (IndicatorsObserver)observers.get(i);
            obs.update(speed, rpm, oilPressure);
        }
    }
    
    public void changeData(int speed, int rpm, int oilPressure){    // метод для изменения характеристик при движении автомобиля
        this.speed = speed;
        this.rpm = rpm;
        this.oilPressure = oilPressure;
        notifyObserver();       // уведомляем слушателей об изменениях
    }    
 
}

interface IndicatorsObserver {
    public void update(int speed, int rpm, int oilPressure);
}

class Dashboard implements IndicatorsObserver {
    private Notifier notifier;
    private int speed;      // скорость
    private int rpm;        // обороты двигателя
    private int oilPressure;    // давление масла

    public Dashboard(Notifier notifier){ 
        this.notifier = notifier;
        notifier.addObserver(this); // регистрируем приборную панель в качестве наблюдателя
    }
    
    public void update(int speed, int rpm, int oilPressure) {
        this.speed = speed;
        this.rpm = rpm;
        this.oilPressure = oilPressure;
        show();
    }
    
    // отображение на приборной панели информации
    public void show(){
        System.out.println("Speed = " + speed + ", RPM = " + rpm + 
                ", Oil pressure = " + oilPressure);
    }
    
    
}

public class ObserverExample2 {    
	
    public static void main(String[] args) {
        CentralComp cp = new CentralComp(); //создаем центральный процессор
        Dashboard db = new Dashboard(cp);   //создаем приборную панель
        
        cp.changeData(10, 2000, 30);
        cp.changeData(20, 2500, 40);
        cp.changeData(60, 5000, 80);
        cp.changeData(80, 4000, 100);
    }
    
}


