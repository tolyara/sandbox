package interview.programania;

// Bucket/segment locking -> faster that synchronized map

// Any number of threads can read elements without blocking it

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    public static void main(String[] args) throws InterruptedException {
//        Map<Integer, String> map = new HashMap<>(); // java.util.ConcurrentModificationException will occur
        Map<Integer, String> map = new ConcurrentHashMap<>();

        map.put(1, "Name1");
        map.put(2, "Name2");
        map.put(3, "Name3");
        map.put(4, "Name4");
        map.put(5, "Name5");

        map.put(10, null);          // NPE will happen
        map.put(null, "Name10");    // NPE will happen

        System.out.println(map);

        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer i = iterator.next();
                System.out.println(i + " : " + map.get(i));
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(6, "Name6");
        };

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(map);
    }

}
