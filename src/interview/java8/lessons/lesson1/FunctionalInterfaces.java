package interview.java8.lessons.lesson1;

public class FunctionalInterfaces {
	
	public static void main(String[] args) {
//		Predicate<Integer> predicate = x ->  x > 5;
//		System.out.println(predicate.test(63));
		
//		Consumer<Integer> consumer = x -> System.out.println(x);
//		consumer.accept(13);
		
//		Supplier<Integer> supplier = () -> new Integer(130);
//		System.out.println(supplier.get());
		
//		Function<Integer, String> function = x -> x.toString(); 
//		String result = function.apply(45);
//		System.out.println(result + " - " + result.getClass());
		
//		UnaryOperator<Integer> unaryOperator = x -> x * x;
//		System.out.println(unaryOperator.apply(5));
		
//		BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
//		System.out.println(binaryOperator.apply(12, 3));
		
		MyPredicate<Integer> myPredicate = x -> System.out.println(x + x);
		myPredicate.apply(5);
	}

}

interface MyPredicate<T> {
	
	void apply(T t);
	
}