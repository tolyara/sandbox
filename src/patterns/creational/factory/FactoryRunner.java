package patterns.creational.factory;

public class FactoryRunner {
	
	public static void main(String[] args) {
		DeveloperFactory developerFactory = DeveloperFactoryGenerator.createDeveloperFactoryBySpecialty("java");
		Developer developer = developerFactory.createDeveloper();
		developer.writeCode();
		DeveloperFactory developerFactory2 = DeveloperFactoryGenerator.createDeveloperFactoryBySpecialty("c++");
		Developer developer2 = developerFactory2.createDeveloper();
		developer2.writeCode();
		DeveloperFactory developerFactory3 = DeveloperFactoryGenerator.createDeveloperFactoryBySpecialty("php");
		Developer developer3 = developerFactory3.createDeveloper();
		developer3.writeCode();
	}

}








//DeveloperFactory developerFactory = new JavaDeveloperFactory();
//Developer developer = developerFactory.createDeveloper();
//developer.writeCode();
//DeveloperFactory developerFactory2 = new CppDeveloperFactory();
//Developer developer2 = developerFactory2.createDeveloper();
//developer2.writeCode();