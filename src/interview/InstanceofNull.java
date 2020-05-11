package interview;

import java.util.Objects;

public class InstanceofNull {
	
	public static void main(String[] args) {
		Object object1 = new Object();
		test(object1);
		
		Object object2 = null;
		test(object2);
	}

	private static void test(Object object) {
//		if (object instanceof null) {
//			System.out.println("Null");
//		}
//		else {
//			System.out.println("Not null");
//		}
		
		if (Objects.isNull(object)) {
			System.out.println("Null");
		}
		else {
			System.out.println("Not null");
		}
		
	}

}
