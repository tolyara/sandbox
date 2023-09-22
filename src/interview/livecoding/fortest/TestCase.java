package interview.livecoding.fortest;

public class TestCase<E, T> {

    private E expected;

    private T target;

    public TestCase(E expected, T target) {
        this.expected = expected;
        this.target = target;
    }

    public E getExpected() {
        return expected;
    }

    public void setExpected(E expected) {
        this.expected = expected;
    }

    public T getTarget() {
        return target;
    }

    public void setTarget(T target) {
        this.target = target;
    }

}
