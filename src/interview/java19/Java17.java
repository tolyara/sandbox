package interview.java19;

import java.util.concurrent.ExecutionException;

// javac Java17.java --enable-preview --release 19
//
public class Java17 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        JEP_406_PatternMatchingForSwitch("Hello");
//        JEP_406_PatternMatchingForSwitch(123);
//        JEP_406_PatternMatchingForSwitch(new MyObject("test", 10));

        JEP_409_SealedClasses();
    }

    /*
        TODO: Scanner, null
        https://www.youtube.com/watch?v=9yZ7CQzjHSQ&ab_channel=Jetbulb
     */
//    private static void JEP_406_PatternMatchingForSwitch(Object o) {
//        switch (o) {
//            case String s -> System.out.println("String : " + s);
//            case Integer i -> System.out.println("Integer : " + i);
//            default -> System.out.println("Object : " + o);
//        }
//    }

    /*
        Sealed interfaces/classes used to restrict not desirable (unwanted) inheritance
     */
    private static void JEP_409_SealedClasses() {
//        new DoubleTriangle().draw();
    }

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

//sealed interface Shape permits Triangle, Qube {
//    void draw();
//}
//
//non-sealed interface Qube extends Shape {}
//
//interface DoubleQube extends Qube {}
//
//sealed interface Triangle extends Shape permits DoubleTriangle {}
//
////final class DoubleTriangle implements Triangle {
//non-sealed class DoubleTriangle implements Triangle {
//    @Override
//    public void draw() {
//        System.out.println("DoubleTriangle is not-sealed");
//    }
//}

