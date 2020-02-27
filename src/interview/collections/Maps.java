package interview.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {

	public static void main(String[] args) {

		Map<String, String> hashMap = new HashMap<>(); // initial size 16
		Map<String, String> linkedHashMap = new LinkedHashMap<>();
		Map<String, String> treeMap = new TreeMap<>();
		Map<String, String> hashTable = new Hashtable<>();
		Map<String, String> syncHashMap = Collections.synchronizedMap(new HashMap<>());

		TreeMap<String, String> treeMap2 = new TreeMap<>();
		treeMap2.put("a", "1");
		treeMap2.put("b", "2");
		treeMap2.put("c", "3");
		treeMap2.put("d", "4");
		treeMap2.put("e", "5");

		System.out.println(treeMap2.subMap("a", "c"));
		System.out.println(treeMap2.subMap("c", "e"));
		System.out.println();

		hashMap.put("a", "1");
		hashMap.put("b", "2");
		hashMap.put("c", "3");

		for (Map.Entry<String, String> item : hashMap.entrySet()) {
			System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
		}

//		Set set = hashMap.entrySet();
//		Iterator iterator = set.iterator();
//		while (iterator.hasNext()) {
//			Entry<String, String> entry = (Entry<String, String>) iterator.next();
//			String value = se
//		}

//		|    | Node<> |   |
//			   Node2<>
	}

}