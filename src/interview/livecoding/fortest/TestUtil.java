package interview.livecoding.fortest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TestUtil {

    public static void printTestResult(Object expected, Object result) {
        System.out.println("(" + (expected.equals(result) ? "+" : "-") + ") " + expected + " -> " + result);
    }

    public static void printTestResultIgnoreOrder(Collection expected, Collection result) {
        Set expectedSet = new HashSet(expected);
        Set resultSet = new HashSet(result);
        printTestResult(expectedSet, resultSet);
    }

}
