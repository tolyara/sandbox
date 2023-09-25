package algorithms;

import interview.livecoding.fortest.TestCaseArrayInt;
import interview.livecoding.fortest.TestCaseArrayIntReturnsBoolean;
import interview.livecoding.fortest.TestUtil;

import java.util.List;

/**
 *
 * In the two-pointer approach, pointers refer to an array’s indexes. By using pointers, we can process two elements per loop, instead of just one.
 *
 * Common patterns in the two-pointer approach involve: *
 * Two pointers each starting from the beginning and the end until they both meet
 * One pointer moves at a slow pace while the other pointer moves at a faster pace
 *
 * Both of the above patterns can help us to reduce the time and space complexity of our problems as we get the expected result in fewer iterations
 * and without using too much additional space.
 *
 */
public class TwoPointerTechnique {

    public static void main(String[] args) {
        runTestCases();
    }

    private static void runTestCases() {
        List<TestCaseArrayIntReturnsBoolean> testCases = List.of(
                new TestCaseArrayIntReturnsBoolean(true, new int[]{1, 1, 2, 3, 4, 6, 8, 9}, 11),
                new TestCaseArrayIntReturnsBoolean(false, new int[]{1, 1, 2, 3, 4, 6, 8, 9}, 20)
        );

        testCases.forEach((t) -> {
            boolean result = sumExistsInArray(t.getTarget(), t.getTargetValue());
            TestUtil.printTestResult(t.getExpected(), result);
        });
    }

    private static boolean sumExistsInArray(int[] input, int targetValue) {
        int pointerOne = 0;
        int pointerTwo = input.length - 1;

        while (pointerOne < pointerTwo) {
            int sum = input[pointerOne] + input[pointerTwo];

            if (sum == targetValue) {
                return true;
            } else if (sum < targetValue) {
                pointerOne++;
            } else {
                pointerTwo--;
            }
        }
        return false;
    }

}
