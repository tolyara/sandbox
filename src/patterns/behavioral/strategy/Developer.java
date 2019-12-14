package patterns.behavioral.strategy;

public class Developer {
	
	private Activity activity;

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	public void executeActivity() {
		activity.justDoIt();
	}

}
