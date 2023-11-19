package interview.livecoding.leetcode;

import interview.livecoding.fortest.TestCaseArrayStr;
import interview.livecoding.fortest.TestCaseArrayStrReturnsListOfInt;
import interview.livecoding.fortest.TestUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        if (s.length() < t.length()) return "";
        if (s.equals(t)) return s;

        char[] chars = s.toCharArray();
        List<Character> targetChars = getCharsList(t);
        List<String> substrings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < targetChars.size(); j++) {
                if (chars[i] == targetChars.get(j)) {
                    sb.append(chars[i]);
                    targetChars.remove(j);
                    if (targetChars.isEmpty()) {
                        targetChars = getCharsList(t);
                        substrings.add(sb.toString());
                        sb = new StringBuilder();
                    }
                }
            }
        }
        return substrings.stream().min(Comparator.comparingInt(String::length)).orElse("");
    }

    private static List<Character> getCharsList(String str) {
        char[] chars = str.toCharArray();
        List<Character> result = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            result.add(chars[i]);
        }
        return result;
    }

}
