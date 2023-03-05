package interview.java8.lessons;

import java.util.function.*;

public class Java8Functions {

    public static final String str = "Hello";

    public static void main(String[] args) {
//        predicate("Hello");
//        supplier();
//        booleanSupplier();
//        consumer();
//        function();
        biFunction();
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

    // Represents a supplier of boolean-valued results.
    private static void booleanSupplier() {
        BooleanSupplier booleanSupplier = () -> Integer.valueOf(str.indexOf("lo")).equals(3);
//        BooleanSupplier booleanSupplier = () -> {
//            return Integer.valueOf(str.indexOf("lo")).equals(3);
//        };
        System.out.println(booleanSupplier.getAsBoolean());
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

    // Represents a function that accepts two arguments and produces a result.
    private static void biFunction() {
        BiFunction<Double, Integer, String> biFunction = (base, degree) -> {
            return "square value = " + (Math.pow(base, degree));
        };
        System.out.println(biFunction.apply(1.5, 3));
    }

}
