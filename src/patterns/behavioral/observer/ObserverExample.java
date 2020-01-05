package patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverExample {
	
	public static void main(String[] args) {
		Observer observer1 = new Observer("one");
		Observer observer2 = new Observer("two");
		observer1.setState("new state");
		observer2.setState("new state 2");
	}

}

class Observer {
	
	static List<Observer> observers = new ArrayList<Observer>();
	
	String name;
	String state;
	
	public Observer(String name) {
		super();
		this.name = name;
		observers.add(this);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		notifyAllObservers();
	}

	private void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	private void update() {
		System.out.println(name + " changed status to : " + state);
	}

	@Override
	public String toString() {
		return "Observer [name=" + name + ", state=" + state + "]";
	}	
	
}
