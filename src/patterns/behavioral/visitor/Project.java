package patterns.behavioral.visitor;

public class Project implements ProjectElement {

	ProjectElement[] projectElements;

	public Project() {
		this.projectElements = new ProjectElement[] {
				new ProjectClass(),
				new ProjectDatabase(),
				new ProjectTest()
		};
	}

	@Override
	public void beWritten(Developer developer) {
		for (ProjectElement projectElement : projectElements) {
			projectElement.beWritten(developer);
		}
	}

}
