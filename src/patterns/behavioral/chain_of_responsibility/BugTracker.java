package patterns.behavioral.chain_of_responsibility;

public class BugTracker {
	
	public static void main(String[] args) {
		
		Notifier reportNotifier = new SimpleReportNotifier(Priority.MAJOR);
		Notifier emailNotifier = new EmailNotifier(Priority.CRITICAL);
		Notifier smsNotifier = new SMSNotifier(Priority.BLOCKER);
		
		reportNotifier.setNextNotifier(emailNotifier);
		emailNotifier.setNextNotifier(smsNotifier);
		
		reportNotifier.notidyManager("Everything is OK.", Priority.MAJOR);  // 1 situation
		reportNotifier.notidyManager("Something is broken.", Priority.CRITICAL);  // 2 situation
		reportNotifier.notidyManager("Everything is crashed!!!", Priority.BLOCKER);  // 3 situation

	}
	

}
