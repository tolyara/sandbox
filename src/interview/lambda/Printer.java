package interview.lambda;

import java.io.IOException;

//@FunctionalInterface
@FunctionalInterface
public interface Printer {
	
	public static void test1() {
		
	}
	
	public default void test2() {
		
	}
	
	public void print() throws IOException;

}
