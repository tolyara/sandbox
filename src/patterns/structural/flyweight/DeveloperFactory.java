package patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

// flyweight
public class DeveloperFactory {

	private static final Map<String, Developer> developers = new HashMap<>();

	public Developer getDeveloperBySpecialty(String specialty) {
		Developer developer = developers.get(specialty);
		if (developer == null) {
			switch (specialty) {
			case "java":
				System.out.println("Creating new specialty - Java developer... ");
				developer = new JavaDeveloper();
				break;
			case "c++":
				System.out.println("Creating new specialty - C++ developer... ");
				developer = new CppDeveloper();
				break;
			default:
				throw new RuntimeException("No found such specialty");
			}
			developers.put(specialty, developer);
		}
		return developer;
	}

}
