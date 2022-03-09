package interview.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Lists {
	
	public static void main(String[] args) {
		List<String> linkedList = new LinkedList<String>();
		List<String> arrayList = new ArrayList<String>();
		
//		List<Number> list = new ArrayList<>();
//		list.add(1);
//		list.add(1.0);
//		list.add(1L);
//		System.out.println(list);
		
		Map map = new HashMap(); 
		map.put(map, "text"); 
		System.out.println(map.get(map));
		
		Stack<String> stack = new Stack<String>();
	}

}
