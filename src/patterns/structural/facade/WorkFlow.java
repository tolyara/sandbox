package patterns.structural.facade;

public class WorkFlow {

	Developer developer = new Developer();
	Job job = new Job();
	BugTracker bugTracker = new BugTracker();
	
	public void beginWorkProcess() {
		job.doJob();
		bugTracker.startSprint();
		developer.doJobBeforeDeadline(bugTracker);
		bugTracker.finishSprint();
		developer.doJobBeforeDeadline(bugTracker);
	}
	
}

