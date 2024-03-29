package interview.livecoding.leetcode;

import interview.livecoding.fortest.TestCaseArrayStr;
import interview.livecoding.fortest.TestCaseArrayStrReturnsListOfInt;
import interview.livecoding.fortest.TestUtil;

import java.util.*;

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
                new TestCaseArrayStr("CBANC", new String[] {"ADOBECODECBANC", "ABCC"}),
                new TestCaseArrayStr("a", new String[] {"a", "a"}),
                new TestCaseArrayStr("", new String[] {"a", "aa"})
        );

        testCases.forEach((t) -> {
            String result = getMinimumWindowSubstring2(t.getTarget()[0], t.getTarget()[1]);
            TestUtil.printTestResult(t.getExpected(), result);
        });
    }

    public static String getMinimumWindowSubstring(String s, String t) {
        if (s.length() < t.length()) return "";
        if (s.equals(t)) return s;

        List<String> substrings = new ArrayList<>();
        char[] chars = s.toCharArray();

        List<Character> targetChars = getCharsList(t);
        StringBuilder sb = new StringBuilder();
        boolean substringBuildInProgress = false;

        for (int i = 0; i < chars.length; i++) {
            if (targetChars.contains(chars[i])) {
                if (!substringBuildInProgress) {
                    substringBuildInProgress = true;
                }
                sb.append(chars[i]);

                // remove matching char from targetChars
                Iterator<Character> targetCharsIterator = targetChars.iterator();
                while (targetCharsIterator.hasNext()) {
                    Character next = targetCharsIterator.next();
                    if (next == chars[i]) {
                        targetCharsIterator.remove();
                        break;
//                        System.out.println("REMOVE " + chars[i]);
                    }
                }

                // if no chars left - reset substring build process
                if (targetChars.isEmpty()) {
                    substringBuildInProgress = false;
                    targetChars = getCharsList(t);
                    substrings.add(sb.toString());
                    sb = new StringBuilder();
                    System.out.println("RESET");
                }
//                System.out.println(sb);
//                System.out.println(targetChars);
            } else {
                if (substringBuildInProgress) {
                    sb.append(chars[i]);
                }
            }
        }
        System.out.println(substrings);
        return substrings.stream().min(Comparator.comparingInt(String::length)).orElse("");
    }

    public static String getMinimumWindowSubstring2(String s, String t) {
        if (s.length() < t.length()) return "";
        if (s.equals(t)) return s;

        List<String> substrings = new ArrayList<>();
        char[] chars = s.toCharArray();

        List<Character> targetChars = getCharsList(t);;
        StringBuilder sb;

        for (int i = 0; i < chars.length; i++) {
            if (targetChars.contains(chars[i])) {
                targetChars = getCharsList(t);
                sb = new StringBuilder();
                for (int j = i; j < chars.length; j++) {
                    sb.append(chars[j]);

                    Iterator<Character> iterator = targetChars.iterator();
                    while (iterator.hasNext()) {
                        Character next = iterator.next();
                        if (next == chars[j]) {
                            iterator.remove();
                            break;
                        }
                    }

                    if (targetChars.isEmpty()) {
                        targetChars = getCharsList(t);
                        substrings.add(sb.toString());
                        break;
                    }
                }
            }
        }
//        System.out.println(substrings);
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
