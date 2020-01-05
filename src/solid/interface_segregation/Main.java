package solid.interface_segregation;

public class Main {
	
	public static void main(String[] args) {
		Cook cook = new Cook();
		WaiterTrainee trainee = new WaiterTrainee();
		cook.work();
		cook.eat();
		trainee.work();
	}

}

interface Worker {
	
	public void work();
	
}

interface Eater {
	
	public void eat();
	
}

class Cook implements Worker, Eater {

	@Override
	public void eat() {
		System.out.println("Cook eat... ");
	}

	@Override
	public void work() {
		System.out.println("Cook cooks food... ");
	}	
	
}

class WaiterTrainee implements Worker {

	@Override
	public void work() {
		System.out.println("Waiter delivers food... ");
	}	
	
}





//interface IWorker {
//	
//	public void work();
//	public void eat();
//
//}

















