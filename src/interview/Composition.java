package interview;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Composition {

	public static void main(String[] args) {

		MyHashSet<String> set = new MyHashSet<>();
//		MyHashSetCompositionStyle<String> set = new MyHashSetCompositionStyle<>();
		set.addAll(Arrays.asList("111", "222", "333"));
		System.out.println(set.getCountOfAddedElements());

	}

}

class MyHashSet<E> extends HashSet<E> {

	private static final long serialVersionUID = 1L;
	private int countOfAddedElements = 0;

	@Override
	public boolean add(E e) {
		countOfAddedElements++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		countOfAddedElements += collection.size();
		System.out.println("1 - " + countOfAddedElements);
		
		boolean isAllAdded = super.addAll(collection);
		System.out.println("2 - " + countOfAddedElements);
		
		return isAllAdded;
	}

	public int getCountOfAddedElements() {
		return countOfAddedElements;
	}

}

class MyHashSetCompositionStyle<E> {

	private int countOfAddedElements = 0;
	private final Set<E> set = new HashSet<E>();

	public boolean add(E e) {
		countOfAddedElements++;
		return set.add(e);
	}

	public boolean addAll(Collection<? extends E> collection) {
		countOfAddedElements += collection.size();
		return set.addAll(collection);
	}

	public int getCountOfAddedElements() {
		return countOfAddedElements;
	}	
	
}
