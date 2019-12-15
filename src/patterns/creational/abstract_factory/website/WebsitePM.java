package patterns.creational.abstract_factory.website;

import patterns.creational.abstract_factory.ProjectManager;

public class WebsitePM implements ProjectManager {

	@Override
	public void manageProject() {
		System.out.println("Website PM manages website project... ");
	}

}
