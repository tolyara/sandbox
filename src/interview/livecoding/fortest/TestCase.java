package interview.livecoding.fortest;

public class TestCase {

    private Object expected;

    private Object target;

    public TestCase(Object expected, Object target) {
        this.expected = expected;
        this.target = target;
    }

    public Object getExpected() {
        return expected;
    }

    public void setExpected(Object expected) {
        this.expected = expected;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

}
