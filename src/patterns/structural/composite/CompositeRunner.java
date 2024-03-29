package patterns.structural.composite;

public class CompositeRunner {
	
	public static void main(String[] args) {
		Team team = new Team();
		Developer firstJavaDeveloper = new JavaDeveloper();
		Developer secondJavaDeveloper = new JavaDeveloper();
		Developer cppDeveloper = new CppDeveloper();
		team.addDeveloper(firstJavaDeveloper);
		team.addDeveloper(secondJavaDeveloper);
		team.addDeveloper(cppDeveloper);	
//		team.removeDeveloper(secondJavaDeveloper);
		team.createProject();
	}

}
