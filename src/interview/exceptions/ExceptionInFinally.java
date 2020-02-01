package interview.exceptions;

public class ExceptionInFinally {
	
	@SuppressWarnings("finally")
	public static void main(String[] args) {
		
//		throw new NoSuchMethodError();
		
		try {
			
		}
		catch (ArithmeticException e) {
			
		}
		finally {
			throw new Error("Oh no!");
		}

		
	}

}
