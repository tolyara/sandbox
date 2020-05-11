package interview.exceptions;

import java.io.IOException;

public class Exceptions {

	public static void main(String[] args) throws Exception {
//		System.out.println(getString());
//		test1();

//		throw new IOError(new IOException());

//		new Person2().m1();
		new Worker2().m1();
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
			return "finally";
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

class Person2 {

	String name;

	int age;

	public Person2() {

	}

	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void m1() throws IOException {
		
	}

}

class Worker2 extends Person2 {

	public Worker2() {

	}

	public Worker2(String name, int age) {
		super(name, age);
	}

	@Override
//	void m1() throws IOException, SQLException { // compile error
	void m1() throws IOException {
		
	}

}
