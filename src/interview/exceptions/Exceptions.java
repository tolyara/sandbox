package interview.exceptions;

public class Exceptions {

	public static void main(String[] args) {
//		System.out.println(getString());
		test1();
	}

	static String getString() {
		try {
			throw new Exception();
		} catch (Exception exception) {
			return "catch";
		}
//		catch(IOException exception) {
//			return "catch";
//		}
		finally {
//			return "finally";
		}
	}

	private static void test1() {
		String what = method();
		System.out.println(what);
	}

	private static String method() {
		try {
			return "SomeString";
		} catch (Exception ex) {
			return "Catch message";
		} finally {
			return "Finally message";
		}
	}

}
