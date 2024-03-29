package interview.livecoding.leetcode;

import interview.livecoding.fortest.TestCaseArrayInt;
import interview.livecoding.fortest.TestUtil;
import interview.performance.PerformanceMeasurer;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

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

//    private static final SecureRandom RANDOM_GENERATOR = new SecureRandom();
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
//        runTestCases();
        checkPerformance();
    }

    private static void checkPerformance() {
//        int arrayLength = 200_000;  // getHIndex O(n2) : ~ 607
        int arrayLength = 200_000;  // getHIndex2 O(n) : ~ 36

        int bound = 1000;
        int[] targetArray = new int[arrayLength];

        UnaryOperator<int[]> arrayFiller = (array) -> {
            for (int i = 0; i < arrayLength; i++) {
                targetArray[i] = RANDOM.nextInt(bound) + 1;
            }
            return array;
        };

        Consumer<int[]> action = (array) -> {
            getHIndex2(array);
        };
        new PerformanceMeasurer<int[]>().process(List.of(targetArray), arrayFiller, action);
    }

    private static void runTestCases() {
        List<TestCaseArrayInt> testCases = List.of(
                new TestCaseArrayInt(0, new int[]{}),
                new TestCaseArrayInt(3, new int[]{9, 7, 6, 2, 1}),
                new TestCaseArrayInt(1, new int[]{1, 3, 1}),
                new TestCaseArrayInt(3, new int[]{3, 0, 6, 1, 5}),
                new TestCaseArrayInt(7, new int[]{14, 5, 1, 1, 5, 4, 3, 11, 8, 7, 7, 6, 2, 6, 20, 3, 3, 18, 19, 0}),
                new TestCaseArrayInt(2, new int[]{25, 0, 0, 1, 80})
        );

        testCases.forEach((t) -> {
            int result = getHIndex2(t.getTarget());
            TestUtil.printTestResult(t.getExpected(), result);
        });
    }

    // O(n2)
    private static int getHIndex(int[] citations) {
        int hIndex = 0;
        if (citations.length == 0) return hIndex;

        for (int possibleHIndex = 1; possibleHIndex < citations.length; possibleHIndex++) {
            int articles = 0;
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= possibleHIndex) {
                    articles++;
                }
            }
            if (articles >= possibleHIndex) {
                hIndex = possibleHIndex;
            } else {
                break;
            }
        }
        return hIndex;
    }

    // O(n)
    private static int getHIndex2(int[] citations) {
        /* A HashMAp to get the numbers of papers with the same number of citations only when citation[i] > currentHIndex */
        Map<Integer, Integer> map = new HashMap<>();
        int currentHIndex = 0; // the hIndex of the first i terms.
        int tempIndex = 0; // the number of papers with citations of at least "currentHIndex + 1"
        for (int i = 0; i < citations.length; i++) {
            /* adding only elements that are greater than the currentHIndex to the HashMap and their frequencies as keyValue*/
            if (citations[i] > currentHIndex) {
                if (map.containsKey(citations[i]))
                    map.put(citations[i],
                            1 + map.get(citations[i]));
                else
                    map.put(citations[i], 1);
                /* increase the value of tempIndex by 1 since citations[i] is greater than currentHIndex*/
                tempIndex += 1;
            }
            if (map.containsKey(currentHIndex)) {
                tempIndex -= map.get(currentHIndex); //remove the number of papers of a citatoins of the value of currentHIndex
                map.remove(currentHIndex);//ensuring that the map only contains key-value pair with key > currentHIndex
            }

            /* if there are at least "currentHIndex + 1" papers with at least "currentHIndex + 1" citations update currentHindex to the value of tempIndex */
            if (tempIndex > currentHIndex) currentHIndex = tempIndex;
        }
        return currentHIndex;
    }

}
