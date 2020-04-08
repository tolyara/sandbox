package interview.generics;

public class Generics2 {

	public static void main(String[] args) {
//		Repository<BB> repository = new Repository<>();
		Repository<BB> repository = new Repository<>();
		
		repository.print(1, new BB());
//		repository.showE(123);
	}

}

//class Repository<T extends Number> {
//class Repository<T extends AA & SomeInterface> {
//class Repository<E extends Number, T extends AA & SomeInterface> {

class Repository<T extends AA & SomeInterface> {

//	T t = new T();
//	T t = (T) new Object();

	T t;

	public Repository() {

	}

	public Repository(T t) {
		this.t = t;
	}

//	void print(T parameter) {
//		System.out.println(parameter + " " + this.t);
//	}
	
	<M extends Number> void print(M m, T t) {
		System.out.println("Key=" + m + " equals " + t);
	}
	
//	void showE(E e) {
//		System.out.println(e + " " + e.getClass());
//	}

}

interface SomeInterface {

}

class AA implements SomeInterface {

	@Override
	public String toString() {
		return "AA[]";
	}

}

class BB extends AA implements SomeInterface {

	@Override
	public String toString() {
		return "BB[]";
	}

}

//
//
//
//
//
