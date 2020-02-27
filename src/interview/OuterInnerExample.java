package interview;

public class OuterInnerExample {

	public static void main(String[] args) {
		
		Outer outer = new Outer();		
		Outer.Inner inner = outer.new Inner();
		
		System.out.println(outer.getOuterVariable());
		System.out.println(inner.getInnerVariable());
		
	}

}

class Outer {
	
	String outerVariable = "outer";
	
	public Outer() {
		
	}

	public String getOuterVariable() {
		return outerVariable;
	}

	public void setOuterVariable(String outerVariable) {
		this.outerVariable = outerVariable;
	}

	class Inner {
		
		String innerVariable = "inner";
		
		public Inner() {
			
		}

		public String getInnerVariable() {
			return innerVariable;
		}

		public void setInnerVariable(String innerVariable) {
			this.innerVariable = innerVariable;
		}
	}

}
