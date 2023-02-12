package interview.programania;

import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class ArrayBlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);

        new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    queue.put(++i);
                    System.out.println("Producer put  " + i + " " + queue);
//                    Thread.sleep(1000);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } //thread blocks if queue is full
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Integer j = queue.take();
                    System.out.println("Consumer took " + j + " " + queue);
//                    Thread.sleep(3000);
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } //thread blocks if queue is empty
            }
        }).start();



//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        queue.add(4);
////        queue.add(5);       // java.lang.IllegalStateException: Queue full
//        queue.offer(5);    // no exception, element just won't be added
//        System.out.println(queue);
    }

}
