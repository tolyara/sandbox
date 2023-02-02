package patterns.behavioral.iterator;

public class IteratorRunner {

	public static void main(String[] args) {

		String[] skills = {"Java", "Spring", "Hibernate", "Maven", "PostgreSQL"};
		JavaDeveloper javaDeveloper = new JavaDeveloper("Anatolii Melchenko", skills);
		Iterator iterator = javaDeveloper.getIterator();
		
		System.out.println("Developer: " + javaDeveloper.getName());
		System.out.println("Skills: ");
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toString() + " ");
		}
		
	}
	
}

