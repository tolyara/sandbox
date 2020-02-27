package interview;

import java.io.IOException;
import java.sql.SQLException;

public class AbstractClasses {

	public static void main(String[] args) {
		
	}

}

abstract class Parent {

	void m1() {

	}

	abstract void m2();

}

abstract class Child extends Parent {

	@Override
	abstract void m1();

	@Override
	void m2() {

	}

}

class A {

	Integer m1() throws IOException, SQLException {
		return null;
	}

}

class B extends A {

	@Override
	Integer m1() throws IOException, SQLException {
		return null;
	}

}
