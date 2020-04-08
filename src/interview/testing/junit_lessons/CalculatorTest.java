package interview.testing.junit_lessons;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void testCalc() throws Exception {
		Calculator calculator = new Calculator();
		int result = calculator.makeAddition(3, 4);
		Assert.assertEquals(7, result);
	}

}
