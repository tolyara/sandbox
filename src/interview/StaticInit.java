package interview;

public class StaticInit {
	
	public static void main(String[] args) throws ClassNotFoundException {
//		Class.forName("interview.Cups");
		
//		new Cups();
		
		System.out.println("main() " + Cups.cup1);
	}

}

class Cup {
	
	Cup(int marker) {
		System.out.println("Cup() " + marker);
	}
	
	void f(int marker) {
		System.out.println("f() " + marker);
	}
	
}

class Cups {
	
	static Cup cup1 = new Cup(1);
	
	static Cup cup2 = new Cup(2);
	
	Cup cup3 = new Cup(3);
	
	public Cups() {
		System.out.println("Cups() ");
	}
	
}