package interview;

public class Test1 {

	static {
//		System.out.println("qwerty");
	}

	public static void main(String[] args) throws Throwable {
//		B1.m1();
//		throw new Throwable();
		
		new Abst() {
			
		}.m1();;
	}

}

class A1 {
	
	static void m1() {
		System.out.println("from A1");
	}
	
}

class B1 extends A1 {
	
//	@Override
	static void m1() {
		System.out.println("from B1");
	}
	
}

interface Int1 {
	
	default void f() {
		
	}
	
}

interface Int2 {
	
	default void f() {
		
	}
	
}

interface Int3 extends Int1, Int2 {

	@Override
	default void f() {		
		Int1.super.f();
	}
	
//	 void f();
	
}

//class Int4 implements Int3 {
//	
//	public void f() {
//		Int3.super.
//	}
//	
//}


// --------------------------

abstract class Abst {
	
	void m1() {
		System.out.println("m1");
	}
	
	void m2() {
		
	}
	
}











