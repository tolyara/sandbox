package interview.livecoding.leetcode;

import interview.livecoding.fortest.TestCaseArrayStrReturnsInt;
import interview.livecoding.fortest.TestUtil;

import java.util.List;

public class FirstOccurrenceInString {

    public static void main(String[] args) {
        runTestCases();
    }

    private static void runTestCases() {
        List<TestCaseArrayStrReturnsInt> testCases = List.of(
                new TestCaseArrayStrReturnsInt(0, new String[] {"sadbutsad", "sad"}),
                new TestCaseArrayStrReturnsInt(-1, new String[] {"leetcode", "leeto"}),
                new TestCaseArrayStrReturnsInt(4, new String[] {"leetleeto", "leeto"})
        );

        testCases.forEach((t) -> {
            int result = getFirstOccurrenceIndex(t.getTarget()[0], t.getTarget()[1]);
            TestUtil.printTestResult(t.getExpected(), result);
        });
    }

    public static int getFirstOccurrenceIndex(String haystack, String needle) {
        int needleIndex = 0;

        StringBuilder sb = new StringBuilder();
        char[] chars = haystack.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == needle.charAt(needleIndex)) {
                sb.append(chars[i]);
                if (sb.toString().equals(needle)) {
                    return i - needle.length() + 1;
                }
                needleIndex++;
            } else if (needleIndex > 0) {
                sb = new StringBuilder();
                needleIndex = 0;
                i--;
            }
        }

        return -1;
//        haystack.contains(needle)
    }

}
