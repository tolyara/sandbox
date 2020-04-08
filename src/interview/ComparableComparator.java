package interview;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ComparableComparator {
	
	public static void main(String[] args) {
		Set set = new TreeSet<>(new PersonComparator());
		
		set.add(new Person(4));
		set.add(new Person(6));
		set.add(new Person(5));
		set.add(new Person(8));
		
//		set.add("2");
//		set.add("5");
//		set.add("4");
//		set.add("1");
//		set.add("-1");
		
		for (Object object : set) {
			System.out.println(object);
		}
		
//		System.out.println(new Person(3).compareTo(new Person(11)));
	}
	
	

}

//class Person implements Comparable<Person> {
class Person {
	
	int age;

	public Person(int age) {
		this.age = age;
	}

//	@Override
//	public int compareTo(Person person) {		
//		return this.age - person.age;
//	}

	@Override
	public String toString() {
		return "Person [age=" + age + "]";
	}
	
}

class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {		
		return o1.age - o2.age;
	}	
	
}






//
