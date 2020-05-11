package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualsHashcode {
	
	public static void main(String[] args) {
		
		doBook();
		
	}
	
	static void doBook() {
		
		Book x = new Book("book x");
		Book x1 = new Book("book x");
		Book z = new Book("book z");
		Book z1 = new Book(null);
		
//		System.out.println(x.equals(x1));
//		System.out.println(x.equals(z));
//		System.out.println(x.equals(z1));
		
		Object objectX = (Object) x;
		Object objectX1 = (Object) x1;
		
		System.out.println(x == x1);
	}
	
	static void doClassB() {
		
		Map<ClassB, String> map = new HashMap<ClassB, String>();
		map.put(new ClassB(), "one");
		System.out.println(map.get(new ClassB()));
		
	}
	
	static void doTest1() {
//		System.out.println(new Book("111").hashCode());
//		System.out.println(new Book("222").hashCode());
		
//		System.out.println(new Ticket(123).hashCode());
		
		Book book1 = new Book(null);
		Book book2 = new Book("111");
		
		System.out.println(book1.equals(book2));
	}
	
	static void doTest2() {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		for (Integer number : list) {
			System.out.println(number.hashCode());
		}
	}

}

class Book {
	
	String title;

	public Book(String title) {
		this.title = title;
	}

	// returns memory address if don't override it
	@Override  
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}

class Ticket {
	
	int number;

	public Ticket(int number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
//		return number;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Ticket other = (Ticket) obj;
//		if (number != other.number)
//			return false;
//		return true;
//	}
	
	
	
}

class ClassB {
	
	int i;

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + i;
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassB other = (ClassB) obj;
		if (i != other.i)
			return false;
		return true;
	}
	
}




