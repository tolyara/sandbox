package patterns.behavioral.visitor;

public interface Developer {
	
	public void create(ProjectClass projectClass);
	
	public void create(ProjectDatabase projectDatabase);

	public void create(ProjectTest projectTest);

}
