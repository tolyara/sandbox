package interview;

import java.util.Arrays;

public class ArraysInteger {
	
	public static void main(String[] args) {
		Integer[] array1 = {
				new Integer(1),
				new Integer(2),
				3
		};		
		Integer[] array2 = new Integer[] { // may use as parameter in some method
				new Integer(4),
				new Integer(5),
				6
		};		
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
	}

}
