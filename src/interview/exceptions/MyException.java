package interview.exceptions;

public class MyException {

	public static void main(String[] args) {
		int num = 0;
		int result = 1;
		if (num < 1) {
			throw new FactorialException("The number is less than 1", num);
		}
		for (int i = 1; i <= num; i++) {

			result *= i;
		}
		System.out.println(result);
	}

}

class FactorialException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int number;

	public int getNumber() {
		return number;
	}

	public FactorialException(String message, int num) {

		super(message);
		number = num;
	}

}
