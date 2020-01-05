package solid.single_responsibility;

public class Main {
	
	public static void main(String[] args) {
		UniversalEmployee universalEmployee = new UniversalEmployee();
		universalEmployee.cook();
		universalEmployee.cleanFloor();
	}

}

interface Employee {
	
	int getSalary();
	
}

class Cook implements Employee {
	
	void cook() {
		System.out.println("Cooking... ");
	}

	@Override
	public int getSalary() {
		return 5000;
	}
	
}

class Janitor implements Employee {
	
	void cleanFloor() {
		System.out.println("Cleaning floor... ");

	}

	@Override
	public int getSalary() {
		return 4000;
	}
	
}

class UniversalEmployee {
	
	Cook cook = new Cook();
	Janitor janitor = new Janitor();
	
	void cook() {
		cook.cook();
	}
	
	void cleanFloor() {
		janitor.cleanFloor();
	}
	
}







//class Employee {
//	
//	int getSalary() {
//		return -1;
//	}
//	
//	void cleanFloor() {
//		
//	}
//	
//	void deliverFood() {
//		
//	}
//	
//}
