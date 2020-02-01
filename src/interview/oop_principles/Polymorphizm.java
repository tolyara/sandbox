package interview.oop_principles;

// dynamic binding in runtime
public class Polymorphizm {
	
	public static void main(String[] args) {
		Car car = new Car();
		Car car2 = new ToyotaSupra();
		car.driving();
		System.out.println(car2.getSeats());
	}

}

class Car {
	
//	int seats = 4;
	 
	public int getSeats() {
		return 4;
	}

	void driving() {
		System.out.println("Driving...");
	}
	
}

class ToyotaSupra extends Car {
	
	@Override
	public int getSeats() {
		return 2;
	}
	
}