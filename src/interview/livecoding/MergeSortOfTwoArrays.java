package interview.livecoding;

public class MergeSortOfTwoArrays {

    public static void main(String[] args) {
        initBlocksExample();
    }

    private static void initBlocksExample() {
        InitBlocksExample initBlocksExample = new InitBlocksExample();
        System.out.println(InitBlocksExample.getI());
        System.out.println(initBlocksExample.getJ());
    }

    private static void mergeSortOfTwoArrays() {
        Integer[] arr1 = new Integer[] {1, 3, 5};
        Integer[] arr2 = new Integer[] {2, 4, 5};
        System.out.println(mergeSortOfTwoArrays(arr1, arr2));
    }

    private static Integer[] mergeSortOfTwoArrays(Integer[] arr1, Integer[] arr2) {
        Integer[] result = new Integer[arr1.length];

        //

        return result;
    }

}

class InitBlocksExample {

    private static int i = 1;

    private int j = 1;

    static {
        System.out.println("Static block");
        i = 2;
    }

    {
        System.out.println("Non-static block");
        j = 2;
    }

    public InitBlocksExample() {
        System.out.println("Constructor");
//        i = 3;
//        j = 3;
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        InitBlocksExample.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

}
