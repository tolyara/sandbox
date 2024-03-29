package interview.livecoding.leetcode;

import interview.livecoding.fortest.TestCaseArrayIntReturnsBoolean2;
import interview.livecoding.fortest.TestUtil;

import java.util.List;

public class JumpGame {

    public static void main(String[] args) {
        runTestCases();
    }

    private static void runTestCases() {
        List<TestCaseArrayIntReturnsBoolean2> testCases = List.of(
//                new TestCaseArrayIntReturnsBoolean2(false, new int[]{}),
//                new TestCaseArrayIntReturnsBoolean2(false, new int[]{0}),
//                new TestCaseArrayIntReturnsBoolean2(true, new int[]{1}),
                new TestCaseArrayIntReturnsBoolean2(true, new int[]{2,3,1,1,4}),

                new TestCaseArrayIntReturnsBoolean2(false, new int[]{3,2,1,0,4}),
                new TestCaseArrayIntReturnsBoolean2(true, new int[]{3,2,2,0,4}),
                new TestCaseArrayIntReturnsBoolean2(true, new int[]{3,2,1,1,4})
        );

        testCases.forEach((t) -> {
            boolean result = canJump(t.getTarget());
            TestUtil.printTestResult(t.getExpected(), result);
        });
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 0) return false;

        int targetLength = nums.length;
        for (int i = nums[0]; i > 0; i--) {
            if (i >= nums.length) return false;
            int currentIndex = nums[i];
            while (currentIndex > 0) {
                if (currentIndex >= targetLength) {
                    return true;
                } else {
                    if (nums[currentIndex] <= 0) return false;
                    currentIndex += nums[currentIndex];
                }
            }
        }
        return false;
    }

}
