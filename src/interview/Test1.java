package interview;

public class Test1 {

	static {
//		System.out.println("qwerty");
	}

	public static void main(String[] args) {
		B1.m1();
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