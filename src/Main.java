import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
    	System.out.println("Beginning...");
        Runnable task = () -> {
    		try {
    			System.out.println("interrupting 1 sec");
    			TimeUnit.SECONDS.sleep(1);
    		} catch (InterruptedException e) {
    			System.out.println("Interrupted");
    		}
    	};
    	Thread thread = new Thread(task);
    	thread.start();
    	thread.join();
    	System.out.println("Finished");
    	AutoCloseable task1 = () -> {
    		System.out.println("AutoCloseable");
    	};
    	task1.close();
    }
}


