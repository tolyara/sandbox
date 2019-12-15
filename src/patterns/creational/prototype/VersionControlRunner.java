package patterns.creational.prototype;

public class VersionControlRunner {
	
	public static void main(String[] args) {
		
		Project master = new Project(1, "SuperProject", "Source code sourcecode = new Sourcecode();");
		System.out.println(master);
		
		ProjectFactory projectFactory = new ProjectFactory(master);
		Project masterCopy = projectFactory.copyProject();
		System.out.println("\n==========================\n");
		System.out.println(masterCopy);
		
	}

}
