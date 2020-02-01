package interview.oop_principles;

// package level - private, access - through getters/setters
public class Encapsulation {

	public static void main(String[] args) {
		Person person = new Person();
//		System.out.println(person.mr + person.name);
		System.out.println(person.getName());
	}

}

class Person {

//	String mr = "mr ";
//	String name = "Max";
	
	private String mr = "mr ";
	private String name = "Max";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
