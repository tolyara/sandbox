package patterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

public class FlyweightRunner {
	
	public static void main(String[] args) {
		
		DeveloperFactory developerFactory = new DeveloperFactory();
		List<Developer> developers = new ArrayList<Developer>();
		
		developers.add(developerFactory.getDeveloperBySpecialty("java"));
		developers.add(developerFactory.getDeveloperBySpecialty("java"));
		developers.add(developerFactory.getDeveloperBySpecialty("java"));
		
		developers.add(developerFactory.getDeveloperBySpecialty("c++"));
		developers.add(developerFactory.getDeveloperBySpecialty("c++"));
		
		for (Developer developer : developers) {
			developer.writeCode();
		}
		
	}

}
