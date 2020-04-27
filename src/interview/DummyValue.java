package interview;

import java.util.HashMap;
import java.util.Map;

public class DummyValue {
	
	private static final Object dummy = new Object();
	
	public static void main(String[] args) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("111", dummy);
		map.put("222", dummy);
		map.put("333", dummy);
		map.put(null, dummy);
		
		System.out.println(map.get("111") == map.get("222"));
		System.out.println(map.get("222") == map.get("333"));
		System.out.println(map.get(null) == map.get("111"));
		
	}

}
