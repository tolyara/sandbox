package patterns.behavioral.visitor;

public class ProjectDatabase implements ProjectElement {

	@Override
	public void beWritten(Developer developer) {
		developer.create(this);
	}

}
