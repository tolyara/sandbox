package interview;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class ReflectionDemo {

	public static void main(String[] args) throws Exception {

//		doClassA();

		for (Class<?> class1 : getSubTypes("java.util.Set")) {
			System.out.println(class1.getSimpleName());
		}

	}

	static void doString() throws Exception {

		String string = "a";
		Field field = String.class.getDeclaredField("value");
		field.setAccessible(true);
		field.set(string, new char[] { 'b' });
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

	static Set<Class<?>> getSubTypes(String packageName) throws Exception {
		Set<Class<?>> classes = new HashSet<>();
		URL resource = Thread.currentThread().getContextClassLoader().getResource(packageName.replace('.', '/'));
		File directory = new File(resource.getFile());
		
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		if (files == null || files.length == 0) {
			return classes;
		}
		
		for (File file : files) {
			// в другие пакеты уходить ненужно
			if (file.isFile() && file.getName().endsWith(".class")) {
				classes.add(Class.forName(
						String.format("%s.%s", packageName, file.getName().substring(0, file.getName().indexOf(".")))));
			}
		}
		return classes;
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
