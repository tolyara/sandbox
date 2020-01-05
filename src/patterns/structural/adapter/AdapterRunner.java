package patterns.structural.adapter;

public class AdapterRunner {

	public static void main(String[] args) {
		Database database = new JavaToDatabaseAdapter();
		database.insert();
		database.update();
		database.select();
		database.delete();
	}
	
}
