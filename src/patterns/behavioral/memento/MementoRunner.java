package patterns.behavioral.memento;

public class MementoRunner {
	
	public static void main(String[] args) throws InterruptedException {
		
		Project project = new Project();
		GithubRepository githubRepository = new GithubRepository();
		
		System.out.println("Creating new project, version 1.0");
		project.setVersionAndDate("version 1.0");
		System.out.println(project);
		
		System.out.println("Saving current project version to GitHub... ");
		githubRepository.setSaver(project.save());
		
		System.out.println("Updating project to version 1.1");		
		System.out.println("Writing bad code... ");
		Thread.sleep(2000);
		project.setVersionAndDate("version 1.1");
		System.out.println(project);
		
		System.out.println("Something went wrong... ");
		System.out.println("Rolling back to version 1.0");
		project.load(githubRepository.getSaver());
		
		System.out.println("Project after rollback: ");
		System.out.println(project);
		
	}

}
