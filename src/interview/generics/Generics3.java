package interview.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics3 {

	public static void main(String[] args) {
		List<Chair> chairs = new ArrayList<Chair>();
		chairs.add(new Chair());
		chairs.add(new IkeaChair());
//		chairs.add(new SkodborgChair());

		List<IkeaChair> ikeaChairs = new ArrayList<>();
		
		testChairs(chairs);
	}

	private static void testChairs(List<? super IkeaChair> chairs) {		
		for (int i = 0; i < chairs.size(); i++) {
			System.out.println(chairs.get(i));
		}
	}

}

class Chair {

	@Override
	public String toString() {
		return "Chair";
	}

}

class IkeaChair extends Chair {

	int height;

	@Override
	public String toString() {
		return "IkeaChair [height=" + height + "]";
	}

}

class SkodborgChair {

}
