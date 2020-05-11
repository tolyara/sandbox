package interview;

public class Cloning {

	public static void main(String[] args) {
		final Person1 person = new Person1("Ali", 30);
		final Person1 personClone = person.getPersonClone();
		person.setName("Baba");

		System.out.println(person);
		System.out.println(personClone);
//		System.out.println(person == personClone);
//		System.out.println(person.equals(personClone));
	}

}

class Person1 implements Cloneable {

	String name;

	final int age;

//	public Person1() {
//		
//	}

	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	Person1 getPersonClone() {
		Person1 person = null;
		try {
			person = (Person1) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return person;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Person1 [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person1 other = (Person1) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

