package interview.alishev;

public class Recursion {

	public static void main(String[] args) {
		
		System.out.println(factorial(15));
	}
	
	// Stack: someMethod() -> someMethod() -> someMethod() -> ...
	
	//recursion needs base case
	protected static void someMethod() {
		System.out.println("Hello");
		someMethod();
	}
	
	// Stack: counter(3) -> counter(2) ->  counter(1) ->  counter(0)
	
	private static void counter(int n) {		
		if (n == 0) {
			return;
		}
		
		System.out.println(n);
		
		counter(n - 1);
		
		System.out.println("After counter(n - 1) with param: " + n);
	}
	
	private static int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		
		return n * factorial(n - 1);
	}
	
}
