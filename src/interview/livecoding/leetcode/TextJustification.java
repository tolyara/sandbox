package interview.livecoding.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 * -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Constraints:
 *
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] consists of only English letters and symbols.
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 *
 * -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 * Example 3:
 *
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 *
 */
public class TextJustification {

    private static final String SPACE = " ";

    public static void main(String[] args) {
        List<String> list = fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);

//        List<String> list = fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16);

//        List<String> list = fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.",
//                "Art","is","everything","else","we","do"}, 20);

        for (String s : list) {
            System.out.println(s);
        }
    }

    // Thisisanexample
    // oftextjustification
    // Thisisanexampleoftextjustification

    // Whatmustbeacknowledgmentshallbe

    // understandwell
    // everythingelsewe

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (lineBuilder.length() + words[i].length() < maxWidth) {
                lineBuilder.append(SPACE).append(words[i]);
            } else {
                result.add(justifyWithSpaces(lineBuilder.toString(), maxWidth));
                lineBuilder = new StringBuilder();
                lineBuilder.append(words[i]);
            }
            if (i == words.length - 1) {
                String line = lineBuilder.toString();
                result.add(addExtraSpacesToEnd(line, maxWidth - line.length()));
            }
        }
        return result;
    }

    private static String justifyWithSpaces(String str, int maxWidth) {
        StringBuilder result = new StringBuilder();
        String[] words = str.split(SPACE);
        int spaceSlots = words.length - 1;
        int extraSpaces = maxWidth - str.length();

        result.append(words[0]);
        if (words.length == 1) {
            return addExtraSpacesToEnd(result.toString(), extraSpaces);
        } else {
            int extraSpacesPerSlot = spaceSlots > 0 ? extraSpaces / spaceSlots : 0;
            int extraSpaceLeftovers = spaceSlots > 0 ? extraSpaces % spaceSlots : 0;

            for (int i = 1; i < words.length; i++) {
                result.append(SPACE);
                for (int j = 0; j < extraSpacesPerSlot; j++) {
                    result.append(" ");
                }
                if (extraSpaceLeftovers > 0) {
                    result.append(" ");
                    extraSpaceLeftovers--;
                }
                result.append(words[i]);
            }
        }

        String resultStr = result.toString();
        if (resultStr.length() != maxWidth) {
            throw new RuntimeException("Final line is not correct. ;" + resultStr + "; " + maxWidth);   // for test
        }
        return resultStr;
    }

    private static String addExtraSpacesToEnd(String str, int extraSpaces) {
        StringBuilder result = new StringBuilder();
        result.append(str);
        for (int j = 0; j < extraSpaces; j++) {
            result.append(" ");
        }
        return result.toString();
    }

}
