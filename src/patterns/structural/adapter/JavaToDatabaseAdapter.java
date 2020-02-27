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





//public class JavaToDatabaseAdapter implements Database {
//	
//	private final JavaApplication javaApp = new JavaApplication();
//
//	@Override
//	public void insert() {
//		javaApp.saveObject();
//	}
//
//	@Override
//	public void update() {
//		javaApp.changeObject();
//	}
//
//	@Override
//	public void select() {
//		javaApp.loadObject();
//	}
//
//	@Override
//	public void delete() {
//		javaApp.removeObject();
//	}
//	
//}




