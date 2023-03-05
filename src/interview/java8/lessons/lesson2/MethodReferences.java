package interview.java8.lessons.lesson2;

import java.util.Arrays;
import java.util.stream.Stream;

public class MethodReferences {

	public static void main(String[] args) {
		Stream.of("one", "two").map(x -> x.toUpperCase());
		Stream.of("one", "two").map(String::toUpperCase);

//		Stream.of(new Student("Anatolii"), new Student("Elena")).map(Student::getName)
//			.forEach(System.out::println);

//		Stream.of(new Student("Anatolii"), new Student("Elena")).map(x -> x.getName().toUpperCase())
//		.forEach(System.out::println);

//		Stream.of("John", "Bill").map(Student::new).forEach(x -> System.out.println(x.getName()));
		Stream.of("John", "Bill").forEach(Utils::print);

//		old();
	}

	private static void old() {
		for (String studentName : Arrays.asList("John", "Bill")) {
			System.out.println(new Student(studentName).getName());
		}
	}

}

class Student {

	String name;

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Utils {

	public static void print(String str) {
		System.out.println(new Student(str).getName());
	}

}