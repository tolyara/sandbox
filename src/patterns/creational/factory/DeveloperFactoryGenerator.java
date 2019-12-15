package patterns.creational.factory;

public class DeveloperFactoryGenerator {

	private DeveloperFactoryGenerator() {

	}

	public static DeveloperFactory createDeveloperFactoryBySpecialty(String specialty) {
		if (specialty.equalsIgnoreCase("java")) {
			return new JavaDeveloperFactory();
		} else if (specialty.equalsIgnoreCase("c++")) {
			return new CppDeveloperFactory();
		} else {
			throw new RuntimeException("Unknown specialty " + specialty);
		}
	}

}
