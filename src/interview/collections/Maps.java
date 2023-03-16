package interview.collections;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Maps {

	public static void main(String[] args) throws Exception {
//		mapInside();
		mapTreeify();
	}

	private static void mapTreeify() throws Exception {
		Map<Dummy, String> map = new HashMap<>();
		final int TREEIFY_THRESHOLD = 8; // default HashMap TREEIFY_THRESHOLD

//		for (int i = 0; i < TREEIFY_THRESHOLD; i++) { 	  // class java.util.HashMap$Node
//		for (int i = 0; i < TREEIFY_THRESHOLD + 2; i++) { // class java.util.HashMap$Node
		for (int i = 0; i < TREEIFY_THRESHOLD + 3; i++) { // class java.util.HashMap$TreeNode
			Dummy dummy = new Dummy(i);
			map.put(dummy, String.valueOf(dummy.var));
			System.out.println();
		}

		Field field = map.getClass().getDeclaredField("table");
		field.setAccessible(true);
		Object[] table = (Object[]) field.get(map);

		for (Object object : table) {
			System.out.println(object + " - " + (object != null ? object.getClass().getName() : ""));
		}
		System.out.println(table.length);

	}

	private static void mapInside() throws Exception {
		Map<Dummy, String> map = new HashMap<>(9);
		Dummy dummy1 = new Dummy(111);
		Dummy dummy2 = new Dummy(222);
		Dummy dummy3 = new Dummy(333);
		Dummy dummy4 = new Dummy(444);
		map.put(dummy1, "one");
		System.out.println();
		map.put(dummy2, "two");
		System.out.println();
		map.put(dummy3, "three");
		System.out.println();
//		map.put(dummy4, "four");
		map.put(dummy3, "three-1");

		Field field = map.getClass().getDeclaredField("table");
		field.setAccessible(true);
		Object[] table = (Object[]) field.get(map);

		// print bucket content and bucket amount
//		for (Object object : table) {
//			System.out.println(object
////					+ " - " + (object != null ? object.getClass() : "")
//			);
//		}
//		System.out.println(table.length);

	}

	private static void concurrentHashMap() {
		Map<String, Integer> concMap = new ConcurrentHashMap<String, Integer>();
	}

	private static void weakHashMap() throws InterruptedException {
		Map<String, String> map;

		map = new WeakHashMap<>();
//		map = new HashMap<>();

		map.put(new String("key1"), "Anatolii");

		Runnable runner = new Runnable() {
			@Override
			public void run() {
				while (map.containsKey("key1")) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Thread is waiting...");
					System.gc();
				}
				System.out.println("Runner finished.");
			}
		};

		Thread thread = new Thread(runner);
		thread.start();
		System.out.println("Application is waiting...");
		thread.join();
	}

	private static void m1() {
		Map<String, String> hashMap = new HashMap<>();
	}

	private static void doMain() {

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

class Dummy {

	int var;

	public Dummy(int var) {
		this.var = var;
	}

	@Override
	public int hashCode() {
//		System.out.println(this + " hashCode() call ...");

//		final int prime = 31;
//		int result = 1;
//		result = prime * result + var;
//		return result;

		return 1;
	}

	@Override
	public boolean equals(Object obj) {
//		System.out.println(this + " equals() call ...");

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dummy other = (Dummy) obj;
		if (var != other.var)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dummy [var=" + var + "]";
	}

}
