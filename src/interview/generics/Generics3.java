package interview.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics3 {
	
	public static void main(String[] args) {
		List<Chair> chairs = new ArrayList<Chair>();
		chairs.add(new IkeaChair());
//		chairs.add(new SkodborgChair());
		
		System.out.println(chairs);
	}

}

class Chair {
	
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
