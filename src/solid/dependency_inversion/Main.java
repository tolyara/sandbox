package solid.dependency_inversion;

public class Main {
	
	public static void main(String[] args) {
		
		User user = new User(new DataAccess());
		user.doJob();
		
	}

}

//  Client -> I <- DataAccess

interface DAO {
	void execute();
}

class DataAccess implements DAO {
	
	@Override
	public void execute() {
		System.out.println("execute... ");
	}
	
}

class Client {
	
	DAO dataAccess = new DataAccess();
	
	void doJob() {
		dataAccess.execute();
	}
	
	
}

// injection
class User {
	
	DAO dataAccess;
	
	public User(DAO dataAccess) {
		this.dataAccess = dataAccess;
	}

	void doJob() {
		dataAccess.execute();
	}
	
	
}
