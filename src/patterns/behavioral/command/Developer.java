package patterns.behavioral.command;

public class Developer {
	
	Command insert;
	Command update;
	Command select;
	Command delete;
	
	public Developer(Command insert, Command update, Command select, Command delete) {
		super();
		this.insert = insert;
		this.update = update;
		this.select = select;
		this.delete = delete;
	}
	
	public void insertRecord() {
		insert.execute();
	}
	
	public void updateRecord() {
		update.execute();
	}
	
	public void selectRecord() {
		select.execute();
	}
	
	public void deleteRecord() {
		delete.execute();		
	}

}
