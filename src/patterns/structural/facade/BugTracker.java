package patterns.structural.facade;

public class BugTracker {
	
	private boolean isSprintActive;

	public boolean isSprintActive() {
		return isSprintActive;
	}

	public void setIsSprintActive(boolean isSprintActive) {
		this.isSprintActive = isSprintActive;
	}
	
	public void startSprint() {
		System.out.println("Sprint is active.");
		isSprintActive = true;
	}
	
	public void finishSprint() {
		System.out.println("Sprint is not active.");
		isSprintActive = false;
	}

}
