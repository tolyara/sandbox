package patterns.behavioral.visitor;

public class ProjectTest implements ProjectElement {

	@Override
	public void beWritten(Developer developer) {
		developer.create(this);
	}

}
