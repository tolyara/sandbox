package interview.multithreading.lessons.lessons1_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollections {
	
	public static void main(String[] args) {
		NameList nameList = new NameList();
		nameList.add("one");
		
		class MyThread extends Thread {
			
			@Override
			public void run() {			
				System.out.println(nameList.removeFirstName());
			}
			
		}
		MyThread myThread = new MyThread();
		myThread.setName("one");
		myThread.start();
		new MyThread().start();
	}
	
//	static class MyThread extends Thread {
//		
//		@Override
//		public void run() {			
//			
//		}
//		
//	}
	
	static class NameList {
		
		List<String> list = Collections.synchronizedList(new ArrayList<>());
		
		void add(String name) {
			list.add(name);
		}
		
		synchronized String removeFirstName() {
			if (list.size() > 0) {
				if (Thread.currentThread().getName().equals("one")) {
					Thread.yield();
				}
				return list.remove(0);
			}
			return "null";
		}
	}

}
