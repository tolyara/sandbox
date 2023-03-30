package interview.java19;

import java.util.concurrent.ExecutionException;

// javac Java17.java --enable-preview --release 19
//
public class Java17 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        JEP_406_PatternMatchingForSwitch("Hello");
//        JEP_406_PatternMatchingForSwitch(123);
//        JEP_406_PatternMatchingForSwitch(new MyObject("test", 10));
    }

//    private static void JEP_406_PatternMatchingForSwitch(Object o) {
//        switch (o) {
//            case String s -> System.out.println("String : " + s);
//            case Integer i -> System.out.println("String : " + i);
//            default -> System.out.println("Object : " + o);
//        }
//    }

}

class MyObject {

    private final String name;
    private final int age;

    MyObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}



