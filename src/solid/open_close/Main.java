package solid.open_close;

public class Main {
	
	public static void main(String[] args) {
		Car celica = new Celica();
		useToWorkInTaxi(celica);
		Car toyota = new Toyota();
		useToWorkInTaxi(toyota);
	}
	
	static void useToWorkInTaxi(Car car) {
		car.workInTaxi();
	}

}

interface Car {
	
	void workInTaxi();
	
}

class Toyota implements Car {
	
	void getPassengers() {
		System.out.println("Getting passengers... ");
	}

	@Override
	public void workInTaxi() {
		getPassengers();
	}
	
}

class Celica extends Toyota {
	
	void getPassenger() {
		System.out.println("Getting one passenger... ");
	}
	
	@Override
	public void workInTaxi() {
		getPassenger();
	}
		
}










