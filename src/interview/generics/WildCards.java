package interview.generics;

import java.util.ArrayList;
import java.util.List;

public class WildCards {
	
	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal(1));
		animals.add(new Animal(2));
		
		List<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog());
		dogs.add(new Dog());
		
		testAnimals(animals);
//		testAnimals(dogs);
		
		List<Object> objects = new ArrayList<>();
		objects.add(new Object());
		objects.add(new Object());
		testAnimals(objects);
	}
	
//	private static void testAnimals(List<? extends Animal> animals) {	
	private static void testAnimals(List<? super Animal> animals) {
		for (Object animal : animals) {
//			System.out.println(animal);
//			animal.eat();
			
			System.out.println(animal.hashCode());
		}
	}

}

/**
 * Object
 * Animal
 * Dog
 */

class Animal {
	
	int id;

	public Animal() {
		
	}

	public Animal(int id) {
		this.id = id;
	}
	
	public void eat() {
		System.out.println("Animal eating...");
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + "]";
	}
	
}

class Dog extends Animal {
	
}

//
//
//
//
