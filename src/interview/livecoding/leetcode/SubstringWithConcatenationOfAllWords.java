package interview.livecoding.leetcode;

import interview.livecoding.fortest.TestCaseArrayStrReturnsListOfInt;
import interview.livecoding.fortest.TestUtil;

import java.util.*;

/**
 *
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 *
 * A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.
 *
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings.
 * "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
 * Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Example 1:
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Since words.length == 2 and words[i].length == 3, the concatenated substring has to be of length 6.
 * The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
 * The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
 * The output order does not matter. Returning [9,0] is fine too.
 * Example 2:
 *
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * Explanation: Since words.length == 4 and words[i].length == 4, the concatenated substring has to be of length 16.
 * There is no substring of length 16 in s that is equal to the concatenation of any permutation of words.
 * We return an empty array.
 * Example 3:
 *
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 * Explanation: Since words.length == 3 and words[i].length == 3, the concatenated substring has to be of length 9.
 * The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"] which is a permutation of words.
 * The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"] which is a permutation of words.
 * The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"] which is a permutation of words.
 *
 */
public class SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        runTestCases();
    }

    private static void runTestCases() {
        List<TestCaseArrayStrReturnsListOfInt> testCases = List.of(
                new TestCaseArrayStrReturnsListOfInt(List.of(0, 9), new String[]{"foo", "bar"}, "barfoothefoobarman"),
                new TestCaseArrayStrReturnsListOfInt(Collections.emptyList(), new String[]{"word", "good", "best", "word"}, "wordgoodgoodgoodbestword"),
                new TestCaseArrayStrReturnsListOfInt(List.of(6, 9, 12), new String[]{"bar", "foo", "the"}, "barfoofoobarthefoobarman"),
                new TestCaseArrayStrReturnsListOfInt(List.of(0), new String[]{"ab", "cd", "ef"}, "abcdef")
        );

        testCases.forEach((t) -> {
            List<Integer> result = findIndexesOfWordsConcatenations(t.getTargetValue(), t.getTarget());
            TestUtil.printTestResultIgnoreOrder(t.getExpected(), result);
        });
    }

    public static List<Integer> findIndexesOfWordsConcatenations(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || s.length() < words[0].length()) return Collections.emptyList();

        List<String> concatenations = getAllConcatenationsOfWordPermutation(words);
        for (String c : concatenations) {
            result.addAll(getOccurrenceIndexes(s, c));
        }
        return result;
    }

    public static List<Integer> getOccurrenceIndexes(String haystack, String needle) {
        List<Integer> result = new ArrayList<>();

        int needleIndex = 0;

        StringBuilder sb = new StringBuilder();
        char[] chars = haystack.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == needle.charAt(needleIndex)) {
                sb.append(chars[i]);
                if (sb.toString().equals(needle)) {
                    result.add(i - needle.length() + 1);
                    sb = new StringBuilder();
                    needleIndex = 0;
                    i--;
                }
                needleIndex++;
            } else if (needleIndex > 0) {
                sb = new StringBuilder();
                needleIndex = 0;
                i--;
            }
        }

        return result;
    }

    private static List<String> getAllConcatenationsOfWordPermutation(String[] words) {
        List<String> result = new ArrayList<>();

        if (words.length == 2) {
            result.add(words[0] + words[1]);
            result.add(words[1] + words[0]);
            return result;
        } else {
            for (int i = 0; i < words.length; i++) {
                String currentWord = words[i];
                String[] wordsWithoutCurrentWord = new String[words.length - 1];

                if (i > 0) {    // copy left side
                    System.arraycopy(words, 0, wordsWithoutCurrentWord, 0, i);
                }
                if (i < words.length - 1) {     // copy right side
                    System.arraycopy(words, i + 1, wordsWithoutCurrentWord, i, words.length - 1 - i);
                }

                List<String> list = getAllConcatenationsOfWordPermutation(wordsWithoutCurrentWord);
                for (String s : list) {
                    result.add(currentWord + s);
                }
            }
        }
        return result;
    }

}
