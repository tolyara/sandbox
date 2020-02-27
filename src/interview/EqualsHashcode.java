package interview;

import java.util.HashMap;
import java.util.Map;

public class EqualsHashcode {
	
	public static void main(String[] args) {
		
		doClassB();
		
	}
	
	static void doBook() {
		
		Book x = new Book("book x");
		Book x1 = new Book("book x");
		Book z = new Book("book z");
		Book z1 = new Book(null);
		
		System.out.println(x.equals(x1));
		System.out.println(x.equals(z));
		System.out.println(x.equals(z1));
		
	}
	
	static void doClassB() {
		
		Map<ClassB, String> map = new HashMap<ClassB, String>();
		map.put(new ClassB(), "one");
		System.out.println(map.get(new ClassB()));
		
	}

}

class Book {
	
	String title;

	public Book(String title) {
		this.title = title;
	}

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




