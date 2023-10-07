package interview.livecoding.leetcode;

import interview.livecoding.fortest.TestCaseArrayString;
import interview.livecoding.fortest.TestUtil;

import java.util.List;

public class ReverseWords {

    public static void main(String[] args) {
        runTestCases();
    }

    private static void runTestCases() {
        List<TestCaseArrayString> testCases = List.of(
//                new TestCaseArrayString("world hello", "  hello world  "),
//                new TestCaseArrayString("blue is sky the", "the sky is blue"),
                new TestCaseArrayString("example good a", "   a good   example  ")
        );

        testCases.forEach((t) -> {
            String result = reverseWords(t.getTarget());
            TestUtil.printTestResult(t.getExpected(), result);
        });
    }

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                System.out.println(words[i]);
            }
        }
        return result.toString();
    }

}
