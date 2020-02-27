package interview;

import java.lang.reflect.Field;

public class ReflectionDemo {
	
	public static void main(String[] args) throws Exception {
		
		doClassA();
		
	}
	
	static void doString() throws Exception {
		
		String string = "a";  
		Field field = String.class.getDeclaredField("value");  
		field.setAccessible(true);  
		field.set(string, new char[]{'b'}); 
		System.out.println(string);
		
	}
	
	static void doClassA() throws Exception {
		
		ClassA classA = new ClassA();  
		
		Field field = ClassA.class.getDeclaredField("finalField");  
		field.setAccessible(true);  
		field.set(classA, 3); 
		
		Field field2 = ClassA.class.getDeclaredField("field");  
		field2.setAccessible(true);
		field2.set(classA, 3); 
		
		System.out.println(classA.getFinalField());
		System.out.println(classA.getField());
		
	}

}

class ClassA {
	
	private final int finalField = -1;
	private int field = -1;

//	public ClassA(int finalField) {
//		this.finalField = finalField;
//	}

	public int getField() {
		return field;
	}

	public int getFinalField() {
		return finalField;
	}
	
}

