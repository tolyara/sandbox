package interview;

public class Test1 {

	static {
//		System.out.println("qwerty");
	}
	
	static char symbol;

	public static void main(String[] args) throws Throwable {
//		B1.m1();
//		throw new Throwable();
		
//		new Abst() {
//		}.m1();;
		
//		System.out.println(Test1.class.getClassLoader());
		
//		A1 a1 = new A1();
//		B1 b1 = (B1) new A1(); 		ClassCastEx
//		a1.m2();
		
//		A1 a1 = new A1();
//		A1 a11 = a1;
//		System.out.println(a1);
//		System.out.println(a11);
		
		System.out.println(">" + symbol + "");
	}

}

class A1 {
	
	static void m1() {
		System.out.println("from A1");
	}
	
	void m2() {
		System.out.println("A1");
	}
	
}

class B1 extends A1 {
	
//	@Override
	static void m1() {
		System.out.println("from B1");
	}
	
	@Override
	void m2() {
		System.out.println("B1");
//		super.m2();
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











