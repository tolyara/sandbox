package interview.exceptions;

public class Exceptions {
	
	public static void main(String[] args) {
		System.out.println(getString());
	}
	
	static String getString() {
		try {
			throw new Exception();
		}
		catch(Exception exception) {
			return "catch";
		}
//		catch(IOException exception) {
//			return "catch";
//		}
		finally {
//			return "finally";
		}
	}

}
