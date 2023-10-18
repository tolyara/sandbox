package interview.livecoding.leetcode;

import interview.livecoding.fortest.TestCaseArrayStr;
import interview.livecoding.fortest.TestCaseArrayStrReturnsListOfInt;
import interview.livecoding.fortest.TestUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        runTestCases();
    }

    private static void runTestCases() {
        List<TestCaseArrayStr> testCases = List.of(
                new TestCaseArrayStr("BANC", new String[] {"ADOBECODEBANC", "ABC"}),
                new TestCaseArrayStr("a", new String[] {"a", "a"}),
                new TestCaseArrayStr("", new String[] {"a", "aa"})
        );

        testCases.forEach((t) -> {
            String result = getMinimumWindowSubstring(t.getTarget()[0], t.getTarget()[1]);
            TestUtil.printTestResult(t.getExpected(), result);
        });
    }

    public static String getMinimumWindowSubstring(String s, String t) {
        String result = "";



        return result;
    }

}
