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
                new TestCaseArrayIntReturnsBoolean2(false, new int[]{}),
                new TestCaseArrayIntReturnsBoolean2(false, new int[]{0}),
                new TestCaseArrayIntReturnsBoolean2(true, new int[]{1}),
                new TestCaseArrayIntReturnsBoolean2(true, new int[]{2,3,1,1,4}),
                new TestCaseArrayIntReturnsBoolean2(false, new int[]{3,2,1,0,4})
        );

        testCases.forEach((t) -> {
            boolean result = canJump(t.getTarget());
            TestUtil.printTestResult(t.getExpected(), result);
        });
    }

    public static boolean canJump(int[] nums) {
        boolean result = true;



        return result;
    }

}
