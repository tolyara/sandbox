package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Draft {
	
	public static void main(String[] args) {
		List<String> arrayList = new ArrayList<String>();
		List<String> linkedList = new LinkedList<String>();
//		Deque<String> arrayDeque = new ArrayDeque<String>();
		
		checkPerformanceAdd(arrayList);
		checkPerformanceAdd(linkedList);
		
//		checkPerformanceInsert(arrayList);
//		checkPerformanceInsert(linkedList);
	}

	// arrayList ~ 50, linkedList ~ 220
	private static void checkPerformanceAdd(List<String> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 2_000_000; i++) {
			list.add("test");
		}
		long end = System.currentTimeMillis();
		System.out.println("time = " + (end - start));
	}
	
	// arrayList ~ 62, linkedList ~ 5
	private static void checkPerformanceInsert(List<String> list) {
		list.add("TEST_ELEMENT_1");
		list.add("TEST_ELEMENT_2");
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 200_000; i++) {
//			list.add(list.size() / 2, "test" + i);
			
//			list.add(0, "test" + i);
			
			list.add(i + 1, "test" + i);
		}
		long end = System.currentTimeMillis();
		
		System.out.println("time = " + (end - start));
	}

}
