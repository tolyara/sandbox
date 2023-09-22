package interview.livecoding.leetcode;

import interview.livecoding.fortest.TestCase;

import java.util.List;

/**
 *
 * The h-index is the largest number h such that h articles have at least h citations each.
 * For example, if an author has five publications, with 9, 7, 6, 2, and 1 citations (ordered from greatest to least),
 * then the author's h-index is 3, because the author has three publications with 3 or more citations.
 * However, the author does not have four publications with 4 or more citations.
 *
 * Another example
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 *
 * Another example
 *
 * Input: citations = [1,3,1]
 * Output: 1
 *
 * Constraints:
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 *
 */
public class IndexH {

    public static void main(String[] args) {
//        Map<Integer, int[]> testCases = Map.of(
        List<TestCase> testCases = List.of(
                new TestCase(3, new int[]{9, 7, 6, 2, 1}),
                new TestCase(1, new int[]{1, 3, 1}),
                new TestCase(3, new int[]{3, 0, 6, 1, 5})
        );

        testCases.forEach((t) -> {
            int result = getHIndex((int[]) t.getTarget());
            System.out.println("(" + (t.getExpected().equals(result) ? "+" : "-") + ") " + t.getExpected() + " -> " + result);
        });
    }

    private static int getHIndex(int[] citations) {
//    private static int hIndex(List<Integer> citations) {

//        int hIndex = 0;
        int hIndex = citations.length;

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] < citations.length) {
                hIndex--;
            }
        }

        return hIndex;
    }

}
