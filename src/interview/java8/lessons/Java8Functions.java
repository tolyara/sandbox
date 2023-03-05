package interview.java8.lessons;

import java.util.function.Predicate;

public class Java8Functions {

    public static final String str = "Hello";

    public static void main(String[] args) {
        predicate("Hello");
    }

    // Represents a predicate (boolean-valued function) of one argument.
    private static void predicate(String target) {
        Predicate<String> predicate = (s) -> {
            return s.equals(str);
        };
        System.out.println(predicate.test(target));
    }

}
