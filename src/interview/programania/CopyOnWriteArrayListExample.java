package interview.programania;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

// It's good to use when we have many reading threads and a little number of modifying threads

// same principle for CopyOnWriteArraySet
public class CopyOnWriteArrayListExample {

    public static void main(String[] args) throws InterruptedException {
//        List<String > list = new ArrayList<>();  // java.util.ConcurrentModificationException will occur
        List<String > list = new CopyOnWriteArrayList<>();
//        Set<String> list = new CopyOnWriteArraySet<>();

        list.add("Name1");
        list.add("Name2");
        list.add("Name3");
        list.add("Name4");
        list.add("Name5");
        System.out.println(list);

        Runnable runnable1 = () -> {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(iterator.next());
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.remove(4);
//            list.remove("Name5");
            list.add("Name6");
        };

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(list);
    }

}
