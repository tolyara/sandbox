package interview.alishev;

// Upcasting, downcasting
public class TypesConversion {
	
	public static void main(String[] args) {
		
		// upcasting
		
//		Animal animal = new Dog();
		Dog dog = new Dog();
		Animal2 animal = dog;
		
		// downcasting
		
		Dog dog2 = (Dog) animal;
		dog2.makeSound();
		
		//exception
		
		Animal2 animal2 = new Animal2();
		Dog dog3 = (Dog) animal2;
		dog3.makeSound();
		
	}

}

class Animal2 {

	public void eat() {
		System.out.println("Animal eating...");
	}
		
}

class Dog extends Animal2 {

	@Override
	public void eat() {
		System.out.println("Dog eating...");
	}

	public void makeSound() {
		System.out.println("Dog barking...");
	}
	
}