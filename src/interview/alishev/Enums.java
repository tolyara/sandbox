package interview.alishev;

public class Enums {

	private static final int DOG = 0;
	private static final int CAT = 1;
	private static final int FROG = 2;

	public static void main(String[] args) {
		withEnum();
	}

	private static void withoutEnum() {
		int animal = DOG;
//		int animal = 100;  

		switch (animal) {
		case DOG:
			System.out.println("dog");
			break;
		case CAT:
			System.out.println("cat");
			break;
		case FROG:
			System.out.println("frog");
			break;
		default:
			System.out.println("not animal");
			break;
		}
	}
	
	private static void withEnum() {
		Animal animal = Animal.CAT;
		
//		System.out.println(animal instanceof Animal);
		
//		System.out.println(animal.getClass());
		
//		System.out.println(animal.getTranslation());
		
//		System.out.println(animal.toString());
		
//		System.out.println(animal.name());
		
//		Animal frog = Animal.valueOf("FROG");
//		System.out.println(frog.getTranslation());
		
//		System.out.println(animal.ordinal());
		
		for (Animal element : Animal.values()) {
			System.out.println(element.getTranslation());
		}
	}

}

// Object -> Enum -> Animal
enum Animal {	
	
//	DOG, CAT, FROG;
	DOG("собака"), CAT("кошка"), FROG("лягушка");
	// new DOG
	// new CAT
	// new FROG
	
	private String translation;
	
//	private Animal() {
//		
//	}
	
	private Animal(String translation) {
		this.translation = translation;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}
	
	@Override
	public String toString() {
		return "Перевод на русский: " + translation;
	}
	
}






