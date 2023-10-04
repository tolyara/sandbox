package interview.livecoding.leetcode;

import interview.livecoding.fortest.TestCaseArrayInt;
import interview.livecoding.fortest.TestUtil;

import java.util.List;

/**
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Example 1:
 * *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        runTestCases();
    }

    private static void runTestCases() {
        List<TestCaseArrayInt> testCases = List.of(
                new TestCaseArrayInt(0, new int[]{}),
                new TestCaseArrayInt(0, new int[]{1, 1}),
                new TestCaseArrayInt(1, new int[]{1, 0, 1}),
                new TestCaseArrayInt(6, new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}),
                new TestCaseArrayInt(9, new int[]{4, 2, 0, 3, 2, 5})
        );

        testCases.forEach((t) -> {
            int result = getMaxTrappedWaterVolume(t.getTarget());
            TestUtil.printTestResult(t.getExpected(), result);
        });
    }

    public static int getMaxTrappedWaterVolume(int[] heights) {
        if (heights.length <= 2) return 0;  // recursion exit condition

        int result = 0;
        int startEdgeHeight = heights[0];
        int startEdgeIndex = 0;

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] >= startEdgeHeight) {
                int slotLength = i - startEdgeIndex - 1;
                if (slotLength > 0) {
                    int slotHeight = Math.min(startEdgeHeight, heights[i]);
                    for (int j = 0; j < slotLength; j++) {
                        int waterVolume = slotHeight - heights[startEdgeIndex + 1 + j];
                        result += waterVolume;
                    }
                }

                startEdgeHeight = heights[i];
                startEdgeIndex = i;
            } else if (i == heights.length - 1) {
                int[] appendix = new int[heights.length - startEdgeIndex - 1];
                System.arraycopy(heights, startEdgeIndex + 1, appendix, 0, heights.length - startEdgeIndex - 1);
                result += getMaxTrappedWaterVolume(appendix);
            }
        }
        return result;
    }

}
