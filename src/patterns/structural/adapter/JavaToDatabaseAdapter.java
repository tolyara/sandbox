package patterns.structural.adapter;

public class JavaToDatabaseAdapter extends JavaApplication implements Database {

	@Override
	public void insert() {
		saveObject();
	}

	@Override
	public void update() {
		changeObject();
	}

	@Override
	public void select() {
		loadObject();
	}

	@Override
	public void delete() {
		removeObject();
	}
	
}
