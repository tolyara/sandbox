package patterns.creational.abstract_factory.banking;

import patterns.creational.abstract_factory.Developer;

public class JavaDeveloper implements Developer {

	@Override
	public void writeCode() {
		System.out.println("Java developer writes Java code... ");
	}

}
