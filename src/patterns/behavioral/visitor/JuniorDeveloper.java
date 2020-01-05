package patterns.behavioral.visitor;

// visitor
public class JuniorDeveloper implements Developer {

	@Override
	public void create(ProjectClass projectClass) {
		System.out.println("Writing poor class... ");
	}

	@Override
	public void create(ProjectDatabase projectDatabase) {
		System.out.println("Broke database... ");
	}

	@Override
	public void create(ProjectTest projectTest) {
		System.out.println("Creating not reliable test... ");
	}

}
