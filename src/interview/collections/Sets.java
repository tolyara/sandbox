package interview.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
	
	public static void main(String[] args) {
	
		Set<String> hashSet = new HashSet<>();
		Set<String> linkedHashSet = new LinkedHashSet<>();
		Set<String> treeSet = new TreeSet<>();
		
		hashSet.add("one");
		hashSet.add("two");
		hashSet.add("three");
		for (String string : hashSet) {
			System.out.println(string);
		}
		System.out.println();
		
		linkedHashSet.add("one");
		linkedHashSet.add("two");
		linkedHashSet.add("three");
		for (String string : linkedHashSet) {
			System.out.println(string); 
		}
		System.out.println();
		
		treeSet.add("one");
		treeSet.add("two");
		treeSet.add("three");
		for (String string : treeSet) {
			System.out.println(string);
		}
		
	}

}
