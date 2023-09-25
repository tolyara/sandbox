package interview.livecoding.leetcode;

import interview.livecoding.fortest.TestCaseArrayInt;
import interview.livecoding.fortest.TestUtil;
import interview.performance.PerformanceMeasurer;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class ContainerWithMostWater {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        runTestCases();
//        checkPerformance();
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
            int result = getMaxArea(t.getTarget());
            TestUtil.printTestResult(t.getExpected(), result);
        });
    }

    private static void checkPerformance() {
//        int arrayLength = 200_000;  // getMaxArea O(n2) : ~ 89026
        int arrayLength = 20_000;  // getMaxArea O(n2) : ~ 1006

        int bound = 10000;
        int[] targetArray = new int[arrayLength];

        UnaryOperator<int[]> arrayFiller = (array) -> {
            for (int i = 0; i < arrayLength; i++) {
                targetArray[i] = RANDOM.nextInt(bound) + 1;
            }
            return array;
        };

        Consumer<int[]> action = (array) -> {
            getMaxArea(array);
        };
        new PerformanceMeasurer<int[]>(arrayLength).process(List.of(targetArray), arrayFiller, action);
    }

    public static int getMaxArea(int[] heights) {
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights.length; j++) {
                if (i == j) continue;   // skip comparing the value to itself
                int length = Math.abs(j - i);
                int height = Math.min(heights[i], heights[j]);
                int tempMaxArea = length * height;
                maxArea = Math.max(maxArea, tempMaxArea);
            }
        }
        return maxArea;
    }

    public static int getMaxArea2(int[] heights) {
        int maxArea = 0;

        return maxArea;
    }

}

