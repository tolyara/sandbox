package interview.livecoding.leetcode;

import interview.livecoding.fortest.TestCaseArrayInt;
import interview.livecoding.fortest.TestUtil;

import java.util.List;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        runTestCases();
    }

    private static void runTestCases() {
        List<TestCaseArrayInt> testCases = List.of(
                new TestCaseArrayInt(0, new int[]{}),
                new TestCaseArrayInt(1, new int[]{1, 1}),
                new TestCaseArrayInt(49, new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}),
                new TestCaseArrayInt(52, new int[]{10, 38, 1, 18, 9, 13})
        );

        testCases.forEach((t) -> {
            int result = getMaxArea(t.getTarget());
            TestUtil.printTestResult(t.getExpected(), result);
        });
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

}

