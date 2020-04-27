package interview.strings;

public class Main {
	
	public static void main(String[] args) {
		
//		String string = "qwerty";
		
//		System.out.println(string.substring(1, 3));
		
//		System.out.println(string.replaceAll("w", "W"));
//		System.out.println(string.replaceAll("a", "A"));

		foo();
		
	}
	
	private static void foo() {
		String s = "111";
		String s1 = s;
		String s2 = s;
		System.out.println(s1 == s2);
	}

}
