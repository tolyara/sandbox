package interview.oop_principles.alishev.polymorphizm;

public class Main {
	
	public static void main(String[] args) {
		
//		Animal animal = new Animal();
		Dog dog = new Dog();
		Cat cat = new Cat();
		
//		test(animal);
		test(dog);
		test(cat);
		
	}
	
	public static void test(Animal animal) {
		animal.eat();
	}

}
