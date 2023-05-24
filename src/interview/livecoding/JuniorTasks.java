package interview.livecoding;

public class JuniorTasks {

    public static void main(String[] args) {
//        task2();
        task3();
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
