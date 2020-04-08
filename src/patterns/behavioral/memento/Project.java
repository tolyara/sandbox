package patterns.behavioral.memento;

import java.util.Date;

public class Project {

	private String version;
	private Date date;

	public void setVersionAndDate(String version) {
		this.version = version;
		this.date = new Date();
	}

	public Saver save() {
		return new Saver(version);
	}

	public void load(Saver saver) {
		version = saver.getVersion();
		date = saver.getDate();
	}

	@Override
	public String toString() {
		return "\nProject [version = " + version + ", date = " + date + "]\n";
	}

}
