package interview;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ComparableComparator {

	public static void main(String[] args) {
		Set<Person> set = new TreeSet<>(new PersonNameComparator());

		set.add(new Person("Person1", 4));
		set.add(new Person("Person2", 6));
		set.add(new Person("Person3", 1));
		set.add(new Person("Person4", 8));

//		set.add("2");
//		set.add("5");
//		set.add("4");
//		set.add("1");
//		set.add("-1");

		for (Object object : ((TreeSet) set).descendingSet()) {
			System.out.println(object);
		}

//		System.out.println(new Person(3).compareTo(new Person(11)));
	}

}

//class Person implements Comparable<Person> {
class Person {

	String name = "";

	int age;

	public Person(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

//	@Override
//	public int compareTo(Person person) {		
//		return this.age - person.age;
//	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}

// if we want to compare by a few fields
class PersonAgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o1.age - o2.age;
	}

}

class PersonNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o1.name.compareTo(o2.name);
	}

}

//
