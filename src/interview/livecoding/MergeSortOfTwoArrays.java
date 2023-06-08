package interview.livecoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSortOfTwoArrays {

    public static void main(String[] args) {
//        initBlocksExample();
//        genericsExample();
        mergeSortOfTwoArrays();
    }

    private static void genericsExample() {
        List<? extends Number> numbers = new ArrayList<>();
//        numbers.add(1);   // compile error

        List<? super Number> numbers2 = new ArrayList<>();
        numbers2.add(1);
        numbers2.add(1.5);
        System.out.println(numbers2);
    }

    private static void initBlocksExample() {
        InitBlocksExample initBlocksExample = new InitBlocksExample();
        System.out.println(InitBlocksExample.getI());
        System.out.println(initBlocksExample.getJ());
    }

    private static void mergeSortOfTwoArrays() {
        Integer[] arr1 = new Integer[] {1, 3, 5};
        Integer[] arr2 = new Integer[] {2, 4, 5};

        Integer[] result = mergeSortOfTwoSortedArrays(arr1, arr2);
        System.out.print("[ ");
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
        System.out.print("]");
    }

    private static Integer[] mergeSortOfTwoSortedArrays(Integer[] arr1, Integer[] arr2) {
        List<Integer> result = new ArrayList<>();

        // easy solution using Collections.sort(...)
        Collections.addAll(result, arr1);
        result.addAll(Arrays.asList(arr2));
        Collections.sort(result);

        Integer[] resultArr = new Integer[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;

        // TODO use direct merge function
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
