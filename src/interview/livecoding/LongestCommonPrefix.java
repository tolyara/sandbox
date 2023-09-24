package interview.livecoding;

import interview.livecoding.fortest.TestCaseArrayStr;
import interview.livecoding.fortest.TestUtil;
import interview.performance.PerformanceMeasurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class LongestCommonPrefix {

    public static void main(String[] args) {
//        runTestCases();
        checkPerformance();
    }

    private static void checkPerformance() {
//        int arrayLength = 200_000;  // getHIndex O(n2) : ~
        int arrayLength = 200_000;  // getHIndex2 O(n) : ~

        String[] targetArray = new String[arrayLength];

        UnaryOperator<String[]> arrayFiller = (array) -> {
            for (int i = 0; i < arrayLength; i++) {
                targetArray[i] = generateRandomString();
            }
            return array;
        };

        Consumer<String[]> action = (array) -> {
            getLongestCommonPrefix(array);
        };

        List<String[]> list = new ArrayList<>();
        list.add(targetArray);
        new PerformanceMeasurer<String[]>(arrayLength).process(list, arrayFiller, action);
    }

    private static void runTestCases() {
        List<TestCaseArrayStr> testCases = List.of(
                new TestCaseArrayStr("fl", new String[]{"flower", "flow", "flight"}),
                new TestCaseArrayStr("prog", new String[]{"progenitive", "prognathouse", "prognosis"}),
                new TestCaseArrayStr("", new String[]{"dog", "racecar", "car"}),
                new TestCaseArrayStr("java", new String[]{"java_9", "java", "java_11", "java_17"}),
                new TestCaseArrayStr("windows", new String[]{"windows", "windows_10", "windows_11"}),
                new TestCaseArrayStr("win", new String[]{"windows", "windows_10", "win_11"}),
                new TestCaseArrayStr("duplicate", new String[]{"duplicate", "duplicate"}),
                new TestCaseArrayStr("Passed", new String[]{"Passed"})
        );

        testCases.forEach((t) -> {
            String result = getLongestCommonPrefix(t.getTarget());
            TestUtil.printTestResult(t.getExpected(), result);
        });
    }

    private static String getLongestCommonPrefix(String[] values) {
        StringBuilder result = new StringBuilder();

        int minLength = values[0].length();
        for (int i = 1; i < values.length; i++) {
            if (values[i].length() < minLength) {
                minLength = values[i].length();
            }
        }
//        System.out.println(minLength);

        if (minLength > 0) {
            for (int i = 0; i < minLength; i++) {   // char's index loop
                char c = values[0].charAt(i);
                boolean matched = true;
                for (int j = 1; j < values.length; j++) {
//                    System.out.println(values[j] + " " + i + " " + j);
                    if (values[j].charAt(i) != c) {
                        matched = false;
                        break;
                    }
                }
                if (matched) {
//                    System.out.println("matched -> " + c);
                    result.append(c);
                } else {
//                    System.out.println("not matched");
                    break;
                }
            }
        }

        return result.toString();
    }

    // Generate Random Alphanumeric String
    private static String generateRandomString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

}
