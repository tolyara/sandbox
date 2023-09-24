package interview.livecoding;

import interview.livecoding.fortest.TestCaseArrayStr;
import interview.livecoding.fortest.TestUtil;

import java.util.List;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        runTestCases();
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

}
