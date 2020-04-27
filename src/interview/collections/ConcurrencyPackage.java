package interview.collections;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;

public class ConcurrencyPackage {

	public static void main(String[] args) {
		
		List<String> list = new CopyOnWriteArrayList<String>();
		Set<String> set = new CopyOnWriteArraySet<String>();
		Queue<String> blockingQueue = new LinkedBlockingQueue<String>();
		
		Map<String, String> map = new ConcurrentHashMap<String, String>();
				
	}
	
}
