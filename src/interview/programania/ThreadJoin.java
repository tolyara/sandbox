package interview.programania;

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(Thread.currentThread().getName() + " finished");
    }

}

class MyThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() +  " finished");
    }

}
