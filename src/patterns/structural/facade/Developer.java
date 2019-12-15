package patterns.structural.facade;

public class Developer {
	
	public void doJobBeforeDeadline(BugTracker bugTracker) {
		if (bugTracker.isSprintActive()) {
			System.out.println("Developer is solving problems... ");
		} else {
			System.out.println("Developer is sleeping at work... ");
		}
	}

}
