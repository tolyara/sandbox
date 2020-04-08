package interview.oop_principles.alishev.polymorphizm;

public class Dog extends Animal {

	@Override
	public void eat() {
		System.out.println("Dog eating...");
	}

	@Override
	public void makeSound() {
		System.out.println("Dog barking...");
	}
	
}
