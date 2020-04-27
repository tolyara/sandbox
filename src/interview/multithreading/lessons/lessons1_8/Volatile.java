package interview.multithreading.lessons.lessons1_8;

//volatile means that will write in main memory, not in cache
public class Volatile {
	
	volatile static int var;
//	static int var;
	
	public static void main(String[] args) {
		new MyReader().start();
		new MyWriter().start();
	}

}

class MyReader extends Thread {

	@Override
	public void run() {
		int localVar = Volatile.var;
		while (localVar < 5) {
			if (localVar != Volatile.var) {
				System.out.println("New value of i is " + Volatile.var);
				localVar = Volatile.var;
			}
		}
	}

}

class MyWriter extends Thread {

	@Override
	public void run() {
		while (Volatile.var < 5) {
			System.out.println("Incrementing i to " + (++Volatile.var));
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}