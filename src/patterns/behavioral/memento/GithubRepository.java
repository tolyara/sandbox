package patterns.behavioral.memento;

public class GithubRepository {
	
	private Saver saver;

	public Saver getSaver() {
		return saver;
	}

	public void setSaver(Saver saver) {
		this.saver = saver;
	};

}
