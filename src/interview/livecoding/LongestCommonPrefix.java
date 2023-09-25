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
//        int arrayLength = 20_000_000;  // getLongestCommonPrefix :  ~ 831
//        int arrayLength = 20_000_000;    // getLongestCommonPrefix2 : ~ 886

//        int arrayLength = 20_000_000;    // array[i] = "checkPerformance"; getLongestCommonPrefix3 : ~ 103
        int arrayLength = 20_000_000;    //  array[i] = generateRandomString(); getLongestCommonPrefix3 : ~ 22386

        String[] targetArray = new String[arrayLength];

        UnaryOperator<String[]> arrayFiller = (array) -> {
            for (int i = 0; i < arrayLength; i++) {
                array[i] = generateRandomString();
//                array[i] = "checkPerformance";
            }
            return array;
        };

        Consumer<String[]> action = (array) -> {
            getLongestCommonPrefix2(array);
        };

        List<String[]> list = new ArrayList<>();
        list.add(targetArray);
        new PerformanceMeasurer<String[]>().process(list, arrayFiller, action);
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
                new TestCaseArrayStr("Passed", new String[]{"Passed"}),
                new TestCaseArrayStr("", new String[]{"", "", ""})
        );

        testCases.forEach((t) -> {
            String result = getLongestCommonPrefix3(t.getTarget());
            TestUtil.printTestResult(t.getExpected(), result);
        });
    }

    private static String getLongestCommonPrefix(String[] values) {
        StringBuilder result = new StringBuilder();

        int minLength = values[0].length();
        for (int i = 1; i < values.length; i++) {

//            if (values[i].length() < minLength) {
//                minLength = values[i].length();
//            }

            minLength = Math.min(values[i].length(), minLength);
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

    private static String getLongestCommonPrefix2(String[] values) {
        StringBuilder result = new StringBuilder();
        int minLength = values[0].length();

//        for (int i = 0; i < minLength; i++) {
//            System.out.print(values[i] + " ");
//        }
//        System.out.println();

        for (int i = 0; i < minLength; i++) {
            char c = values[0].charAt(i);
            boolean matched = true;

            for (int j = 1; j < values.length; j++) {
                if (j == 1) {
                    minLength = Math.min(values[j].length(), minLength);    // determine shortest value's length in first iteration
                }

                if (values[j].charAt(i) != c) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                result.append(c);
            } else {
                break;
            }
        }
        return result.toString();
    }

    private static String getLongestCommonPrefix3(String[] values) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(values);
        String first = values[0];
        String last = values[values.length - 1];
        int minLength = Math.min(first.length(), last.length());

        for (int i = 0; i < minLength; i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    // Generate Random Alphanumeric String
    private static String generateRandomString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
