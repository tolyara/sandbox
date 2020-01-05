package patterns.behavioral.visitor;

//visitor
public class SeniorDeveloper implements Developer {

	@Override
	public void create(ProjectClass projectClass) {
		System.out.println("Rewriting class after junior... ");
	}

	@Override
	public void create(ProjectDatabase projectDatabase) {
		System.out.println("Fixing database... ");
	}

	@Override
	public void create(ProjectTest projectTest) {
		System.out.println("Creating reliable test... ");
	}

}
