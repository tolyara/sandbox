package interview.livecoding.fortest;

public class TestUtil {

    public static void printTestResult(Object expected, Object result) {
            System.out.println("(" + (expected.equals(result) ? "+" : "-") + ") " + expected + " -> " + result);
    }

}
