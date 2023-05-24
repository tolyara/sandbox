package interview.livecoding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class JuniorTasks {

    public static void main(String[] args) {
//        task2();
//        task3();
        task4();
    }

    private static void task1() {
        int[] nums = {1, 2, 3};
        for (int x = 0; x < nums.length; x++) {
            x += nums[x];
        }
//        System.out.println(x);        // compile error
    }

    private static void task2() {
        String m = "Hello";
        System.out.print(m);
        bar(m);
        System.out.print(m);    // “HelloHello”
    }

    private static void task3() {
        OurDemoClass ourDemoClass = new OurDemoClass();
    }

    private static void task4() {
        List<String> stringList = new ArrayList<>();    // ConcurrentModificationException
//        List<String> stringList = new CopyOnWriteArrayList<>();    // After [one, one and a half, two, two and a half, three and a half, three]
        stringList.add("one");
        stringList.add("one and a half");
        stringList.add("two");
        stringList.add("two and a half");
        stringList.add("three and a half");

        System.out.println("Before " + stringList);
        Iterator<String> stringIterator = stringList.iterator();
        while (stringIterator.hasNext()) {
            String next = stringIterator.next();
            if (next.equals("two and a half")) {
                stringList.add("three");
            }
        }
        System.out.println("After " + stringList);
    }

    private static void bar(String m) {
        m += " World!";
    }

}

abstract class OurAbstractClass {

    public OurAbstractClass() {
        System.out.println("This is abstract class constructor");
    }
}

class OurDemoClass extends OurAbstractClass {

    public OurDemoClass() {
        System.out.println("This is demo class constructor");
    }
}
