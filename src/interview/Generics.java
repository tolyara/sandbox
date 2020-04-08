package interview;

public class Generics {

	public static void main(String[] args) {

		lesson1();

	}

	static void lesson1() {

////		List ages = new ArrayList();
//		
//		List<Integer> ages = new ArrayList();
//		ages.add(20);
////		ages.add("str");
//		for (int i = 0; i < ages.size(); i++) {
//			int j = (int) ages.get(i);
//			System.out.println(j);
		
		Cell<String> stringCell = new Cell<>();
		stringCell.setT("hello");
		stringCell.setT("world");
//		stringCell.setT(12);
		String string = stringCell.getT();
		System.out.println(string);
		
		Cell<Integer> integerCell = new Cell<>();
		integerCell.setT(11);
		Integer integer = integerCell.getT();
		System.out.println(integer);

	}
}

class Cell<T> {

	T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}


//class Cell {
//
//	Object object;
//
//	public Object getT() {
//		return object;
//	}
//
//	public void setT(Object object) {
//		this.object = object;
//	}
//
//}







