package patterns.structural.facade;

public class FacadeRunner {

	public static void main(String[] args) {
		WorkFlow workFlow = new WorkFlow();
		workFlow.beginWorkProcess();
	}

}






//Job job = new Job();
//job.doJob();
//BugTracker bugTracker = new BugTracker();
//bugTracker.startSprint();
//Developer developer = new Developer();
//developer.doJobBeforeDeadline(bugTracker);
//bugTracker.finishSprint();
//developer.doJobBeforeDeadline(bugTracker);
