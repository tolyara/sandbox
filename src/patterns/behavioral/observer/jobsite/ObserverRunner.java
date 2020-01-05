package patterns.behavioral.observer.jobsite;

public class ObserverRunner {
	
	public static void main(String[] args) {
		
		DeveloperJobSite jobSite = new DeveloperJobSite();
		jobSite.addVacancy("First Java Position");
		jobSite.addVacancy("Second Java Position");
		
		Observer subscriber1 = new Subscriber("Anatoii Melchenko");
		Observer subscriber2 = new Subscriber("Peter Parker");

		jobSite.addObserver(subscriber1);
		jobSite.addObserver(subscriber2);
		
		jobSite.addVacancy("Third Java Position");

		jobSite.removeVacancy("First Java Position");
		
	}

}
