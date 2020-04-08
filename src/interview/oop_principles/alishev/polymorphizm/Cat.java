package interview.oop_principles.alishev.polymorphizm;

public class Cat extends Animal {

	@Override
	public void eat() {
		System.out.println("Cat eating...");
	}

	@Override
	public void makeSound() {
		System.out.println("Cat meowing...");
	}
	
}
