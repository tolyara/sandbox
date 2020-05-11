package interview.java8.lessons.lesson1;

import java.util.Optional;

public class Optionals {

	public static void main(String[] args) {

//		Object object = getO();
//		object.hashCode();

//		Optional<String> optional = Optional.empty();
//		Optional<String> optional2 = Optional.ofNullable(null);

//		Optional<String> optional = getOptional();
//		if (optional.isPresent()) {
//			System.out.println(optional.get());
//		}
		
//		mapExample();	

	}
	
	private static void  orElseExample() {
		Optional<String> optional = Optional.of("John");
		System.out.println(optional.orElse("blank"));
		
		Optional<String> optional2 = Optional.ofNullable(null);
		System.out.println(optional2.orElse("blank"));
	}
	
	private static void  mapExample() {
		Optional<String> optional = Optional.of("John");
		System.out.println(optional.map((x) -> x.toUpperCase()).orElseThrow());
		
		Optional<String> optional2 = Optional.of("John");
		System.out.println(optional2.flatMap((x) -> Optional.of("Sally")).orElseThrow());
	}

	private static Optional<String> getOptional() {

		if (true) {
			return Optional.of("Null");
		}

		return Optional.empty();
	}

	private static Object getObject() {

		if (true) {
			return null;
		} else {
			return new Object();
		}

	}

}
