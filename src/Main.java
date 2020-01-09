
public class Main {
	public static void main(String[] args) throws Exception {
		I a = new A();
		a.m();
	}
}

interface I {

	public static final int a = 0;

	default void m() {
		System.out.println("default");
	};

}

class A implements I {

	 void m1() {
	}

	void m1(int n) {

	}
}

class B extends A {

	@Override
	void m1() {
	}

//	void m1() {
//
//	}

}
