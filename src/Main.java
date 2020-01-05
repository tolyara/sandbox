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

//	@Override
//	public void m() {
//		System.out.println("A");
//	}

}
