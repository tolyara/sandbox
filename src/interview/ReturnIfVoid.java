package interview;

public class ReturnIfVoid {
	
	public static void main(String[] args) {
		test();
		System.out.println("End main.");
	}

	private static void test() {
		int i = 1;
		if (i == 1) {
			return;
		}
		System.out.println("End test.");
	}
	
	

}
