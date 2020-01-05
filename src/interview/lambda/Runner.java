package interview.lambda;

public class Runner {

	public static void main(String[] args) {
		
		Summator summator = new Summator() {			
			@Override
			public int sum(int a, int b) {				
				return a + b;
			}
		};
		
		/* Data types do not declared */
		Summator summator2 = (a, b) -> a + b; 
		
		System.out.println(summator.sum(2, 7));
		System.out.println(summator2.sum(3, 11));
		
	}
	
}
