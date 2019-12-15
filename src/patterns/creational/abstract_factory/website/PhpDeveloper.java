package patterns.creational.abstract_factory.website;

import patterns.creational.abstract_factory.Developer;

public class PhpDeveloper implements Developer {
	
	@Override
	public void writeCode() {
		System.out.println("Php developer writes PHP code... ");
	}
	
}
