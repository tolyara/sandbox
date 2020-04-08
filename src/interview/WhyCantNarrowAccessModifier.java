package interview;

public class WhyCantNarrowAccessModifier {
	
	public static void main(String[] args) {
//		new A().foo();
//		new B().foo();
		C c = new D();
		c.foo();
	}

}

class C {
	
	void foo() {
		
	}
	
}

class D extends C {
	
	@Override
//	private void foo() {
	void foo() {

		
	}
	
}