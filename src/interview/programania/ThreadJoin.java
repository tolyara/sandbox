package interview.programania;

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " begins");
        Worker worker = new Worker();
        System.out.println(worker.getState());
        worker.start();
        System.out.println(worker.getState());
        worker.join();

        System.out.println("main state : " + Thread.currentThread().getState());
        System.out.println(worker.getState());
        System.out.println(Thread.currentThread().getName() + " finished");

//        System.out.println(Thread.currentThread().getName() + " begins");
//        Worker worker = new Worker();
//        worker.start();
//        worker.join(1500);
////        worker.join(3000);
//        System.out.println(Thread.currentThread().getName() + " finished");

//        Thread t1 = new MyThread();
//        Thread t2 = new MyThread();
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.println(Thread.currentThread().getName() + " finished");
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

class Worker extends Thread {

    @Override
    public void run() {
        System.out.println(this.getName() +  " begins");
//        System.out.println(this.getState());
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() +  " finished");
    }
}
