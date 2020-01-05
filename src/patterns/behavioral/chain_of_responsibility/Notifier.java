package patterns.behavioral.chain_of_responsibility;

public abstract class Notifier {
	
	private int priority;
	private Notifier nextNotifier;
	
	public Notifier(int priority) {
		this.priority = priority;
	}

	public Notifier getNextNotifier() {
		return nextNotifier;
	}

	public void setNextNotifier(Notifier nextNotifier) {
		this.nextNotifier = nextNotifier;
	}
	
	public void notidyManager(String message, int priorityLevel) {
		if (priorityLevel >= priority) {
			write(message);
		}
		if (nextNotifier != null) {
			nextNotifier.notidyManager(message, priorityLevel);
		}
	}
	
	public abstract void write(String message);

}
