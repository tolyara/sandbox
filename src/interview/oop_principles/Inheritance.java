package interview.oop_principles;

// dynamic binding in runtime
public class Inheritance {

	public static void main(String[] args) {
		ToyotaCelica celica = new ToyotaCelica();
		System.out.println(celica.getMaxSpeed());
		System.out.println(celica.getSeats());
	}

}

class Car1 {

	int maxSpeed = 100;

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

}

class ToyotaCelica extends Car1 {
	
	int seats = 2;

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	
}
