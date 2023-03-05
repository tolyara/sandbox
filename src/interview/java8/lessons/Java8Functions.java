package interview.java8.lessons;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8Functions {

    public static final String str = "Hello";

    public static void main(String[] args) {
//        predicate("Hello");
//        supplier();
        consumer();
//        function();
    }

    // Represents a predicate (boolean-valued function) of one argument.
    private static void predicate(String target) {
        Predicate<String> predicate = (s) -> {
            return s.equals(str);
        };
        System.out.println(predicate.test(target));
    }

    // Represents a supplier of results.
    private static void supplier() {
        Supplier<String> supplier = () -> {
            return "Supplier result";
        };
        System.out.println(supplier.get());
    }

    // Represents an operation that accepts a single input argument and returns no result.
    private static void consumer() {
//        Consumer<String> consumer = System.out::println;
        Consumer<String> consumer = (s) -> {
            System.out.println(s.toUpperCase());
        };
        consumer.accept(str);
    }

    // Represents a function that accepts one argument and produces a result.
    private static void function() {
        Function<Integer, String> function = (intValue) -> {
            return "intValue = " + (intValue);
        };
        System.out.println(function.apply(3));
    }

}
