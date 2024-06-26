package interview.livecoding.leetcode;

import interview.livecoding.fortest.TestCaseArrayInt;
import interview.livecoding.fortest.TestUtil;
import interview.performance.PerformanceMeasurer;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Example 1:
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 */
public class ContainerWithMostWater {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
//        runTestCases();
        checkPerformance();
    }

    private static void runTestCases() {
        List<TestCaseArrayInt> testCases = List.of(
                new TestCaseArrayInt(0, new int[]{}),
                new TestCaseArrayInt(1, new int[]{1, 1}),
                new TestCaseArrayInt(49, new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}),
                new TestCaseArrayInt(52, new int[]{10, 38, 1, 18, 9, 13}),
                new TestCaseArrayInt(6, new int[]{1, 5, 4, 3}),
                new TestCaseArrayInt(12, new int[]{3, 1, 2, 4, 5})
        );

        testCases.forEach((t) -> {
            int result = getMaxArea2(t.getTarget());
            TestUtil.printTestResult(t.getExpected(), result);
        });
    }

    private static void checkPerformance() {
//        int arrayLength = 200_000;  // getMaxArea O(n2) : ~ 89026
//        int arrayLength = 20_000;  // getMaxArea O(n2) : ~ 1006

        int arrayLength = 20_000;  // getMaxArea2 O(n) : ~ 2

        int bound = 10000;
        int[] targetArray = new int[arrayLength];

        UnaryOperator<int[]> arrayFiller = (array) -> {
            for (int i = 0; i < arrayLength; i++) {
                targetArray[i] = RANDOM.nextInt(bound) + 1;
            }
            return array;
        };

        Consumer<int[]> action = (array) -> {
            getMaxArea2(array);
        };
        new PerformanceMeasurer<int[]>().process(List.of(targetArray), arrayFiller, action);
    }

    public static int getMaxArea(int[] heights) {
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights.length; j++) {
                if (i == j) continue;   // skip comparing the value to itself
                int length = Math.abs(j - i);
                int height = Math.min(heights[i], heights[j]);
                int currentArea = length * height;
                maxArea = Math.max(maxArea, currentArea);
            }
        }
        return maxArea;
    }

    public static int getMaxArea2(int[] heights) {
        int maxArea = 0;
        int i = 0;
        int j = heights.length - 1;

        while (i < j) {
            int currentArea = (j - i) * Math.min(heights[i], heights[j]);
            maxArea = Math.max(maxArea, currentArea);
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

}

