package solid.dependency_inversion;

public class Main {
	
	public static void main(String[] args) {
		
		User user = new User(new DataAccess());
//		User user = new User(new DataAccess2());

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
		System.out.println("DataAccess executing... ");
	}
	
}

class DataAccess2 implements DAO {
	
	@Override
	public void execute() {
		System.out.println("DataAccess2 executing... ");
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
