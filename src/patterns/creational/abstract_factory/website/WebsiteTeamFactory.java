package patterns.creational.abstract_factory.website;

import patterns.creational.abstract_factory.Developer;
import patterns.creational.abstract_factory.ProjectManager;
import patterns.creational.abstract_factory.ProjectTeamFactory;
import patterns.creational.abstract_factory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {

	@Override
	public Developer getDeveloper() {		
		return new PhpDeveloper();
	}

	@Override
	public Tester getTester() {		
		return new ManualTester();
	}

	@Override
	public ProjectManager getProjectManager() {		
		return new WebsitePM();
	}

}
