package interview.livecoding.fortest;

public class TestCaseArrayIntReturnsBoolean extends TestCase<Boolean, int[]> {

    private final Integer targetValue;

    public TestCaseArrayIntReturnsBoolean(Boolean expected, int[] target, Integer targetValue) {
        super(expected, target);
        this.targetValue = targetValue;
    }

    public Integer getTargetValue() {
        return targetValue;
    }

}
