package interview.livecoding.fortest;

import java.util.List;

public class TestCaseArrayStrReturnsListOfInt extends TestCase<List<Integer>, String[]> {

    private final String targetValue;

    public TestCaseArrayStrReturnsListOfInt(List<Integer> expected, String[] target, String targetValue) {
        super(expected, target);
        this.targetValue = targetValue;
    }

    public String getTargetValue() {
        return targetValue;
    }

}
