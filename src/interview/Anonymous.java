package interview;

public class Anonymous {

	public static void main(String[] args) {

		Popcorn popcorn = new Popcorn() {
			@Override
			void foo() {
				System.out.println("main");
			}
		};
		popcorn.foo();

		method(new Popcorn() {
			@Override
			void foo() {
				System.out.println("bla");
			}
		});
		

	}

	private static void method(Popcorn popcorn) {
		popcorn.foo();
	}

}

class Popcorn {

	void foo() {
		System.out.println("Popcorn");
	}

}