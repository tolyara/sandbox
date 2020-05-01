package interview.java8.lessons;

import java.util.Arrays;
import java.util.List;

public class SumArray {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 5, 8);
		System.out.println(sumArrayImper(list));
		System.out.println(sumArrayFunc(list));
	}

	private static int sumArrayImper(List<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}

	private static int sumArrayFunc(List<Integer> values) {
		return values.stream().reduce((previous, current) -> previous + current).get();
	}

}
