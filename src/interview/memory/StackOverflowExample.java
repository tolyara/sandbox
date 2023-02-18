package interview.memory;

public class StackOverflowExample {

    public static void main(String[] args) {
        runEmptyMethodRecursive();
    }

    private static void runEmptyMethodRecursive() {
        runEmptyMethodRecursive();
    }

}
