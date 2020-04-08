package interview;

public class FinalReferences {
	
	public static void main(String[] args) {
		final int[] array1 = new int[] {1, 2, 3};
		int[] array2 = array1;
		array2[0] = 11;
		System.out.println(array1[0]);
		System.out.println(array2[0]);
	}

}


