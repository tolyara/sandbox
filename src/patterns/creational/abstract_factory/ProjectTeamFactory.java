package patterns.creational.abstract_factory;

public interface ProjectTeamFactory {
	
	Developer getDeveloper();
	
	Tester getTester();
	
	ProjectManager getProjectManager();

}
