package patterns.behavioral.state;

public class StateRunner {
	
	public static void main(String[] args) {
		
		Activity activity = new Sleeping();
		Developer developer = new Developer();
		developer.setActivity(activity);
		
		for (int i = 0; i < 8; i++) {
			developer.doActivity();
			developer.changeActivity();
		}
		
	}

}
