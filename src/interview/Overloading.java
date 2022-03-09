package interview;

public class Overloading {
	
	public static void main(String[] args) {
		new Printer().print(10);
		new FilePrinter().print(args);
	}

}

class Printer {
	
	void print() {
		System.out.println("Stub");
	}
	
	void print(String message) {
		System.out.println("String : " + message);
	}
	
	void print(Number number) {
		System.out.println("Number : " + number);
	}
	
	void print(Integer integer) {
		System.out.println("Integer : " + integer);
	}
	
//	int print() { // compile error
//		
//	}
	
}

class FilePrinter extends Printer {
	
//	@Override
	void print(Object object) {
		System.out.println("Print to file : " + object);
	}
	
}
