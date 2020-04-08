package interview.alishev;

public class InnerClasses {
	
	public static void main(String[] args) {
		
		Electrocar electrocar = new Electrocar(1);
		electrocar.start();
		
		Electrocar.Battery battery = new Electrocar.Battery();
		
	}

}

class Electrocar {
	
	private int id;
	
	//non-static
	private class Motor {
		public void startMotor() {
			System.out.println("Motor of electrocar = " + id + " is starting...");
		}
	}
	
	//static
	public static class Battery {
		public void charge() {
			System.out.println("Battery is charging...");
		}
	}

	public Electrocar(int id) {
		this.id = id;
	}
	
	public void start() {
		Motor motor = new Motor();
		motor.startMotor();		
		
		final int x = 1; // must be const
		
		//in method
		class SomeClass {
			public void someMethod() {
				System.out.println(x);
				System.out.println(id);
			}
		}
		SomeClass someObject = new SomeClass();
		test(someObject);
		
		System.out.println("Electrocar = " + id + " is starting...");
	}
	
	private void test(Object object) {
		
	}
	
}
