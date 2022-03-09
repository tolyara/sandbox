package interview;

import java.math.BigInteger;

public class Wrappers {
	
	public static void main(String[] args) {
		bool();
		
		Object o = new Object();
	}
	
	private static void bigInt() {
		BigInteger bigInteger = new BigInteger("0");
	}
	
	private static void bool() {
		Boolean boolean1 = true;
		Boolean boolean2 = false;
		Boolean boolean3 = null;
		
		System.out.println(boolean1);
		System.out.println(boolean2);
		System.out.println(boolean3);
	}

}
