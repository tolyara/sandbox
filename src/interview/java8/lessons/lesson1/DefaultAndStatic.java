package interview.java8.lessons.lesson1;

public class DefaultAndStatic {
	
	public static void main(String[] args) {
//		System.out.println(A.add(3, 5));
		
		A a = new B();
		a.sayHello();
	}

}

interface A {
	
	static int add(int x, int y) {
		return x + y;
	}
	
	void printMessage(String message);
	
	default void sayHello() {
		printMessage("Hello");
	}
	
}

interface C {
//interface C extends A {
	
	default void sayHello() {
		System.out.println(("Hello from C"));
	}
	
}

class B implements A, C {

	@Override
	public void printMessage(String message) {
		System.out.println(message);
	}

//	@Override
//	public void sayHello() {		
//		C.super.sayHello();		
//	}

	@Override
	public void sayHello() {		
		System.out.println("New Hello");
	}
	
}


//
//
//
//
//
//







