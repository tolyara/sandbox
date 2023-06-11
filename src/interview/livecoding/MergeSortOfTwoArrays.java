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
//        Integer[] arr1 = new Integer[] {1, 3, 5};
//        Integer[] arr2 = new Integer[] {2, 4, 5};

//        Integer[] arr1 = new Integer[] {6, 20, 31};
//        Integer[] arr2 = new Integer[] {4, 5, 17, 18};

        Integer[] arr1 = new Integer[] {7, 20, 31, 32};
        Integer[] arr2 = new Integer[] {4, 5, 17, 22, 24};

        Integer[] result = mergeSortOfTwoSortedArrays(arr1, arr2);
        System.out.print("[ ");
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
        System.out.print("]");
    }

    private static Integer[] mergeSortOfTwoSortedArrays(Integer[] arr1, Integer[] arr2) {
        // 1 - easy solution using Collections.sort(...)
//        List<Integer> result = new ArrayList<>();
//        Collections.addAll(result, arr1);
//        result.addAll(Arrays.asList(arr2));
//        Collections.sort(result);
//
//        Integer[] resultArr = new Integer[result.size()];
//        for (int i = 0; i < result.size(); i++) {
//            resultArr[i] = result.get(i);
//        }
//        return resultArr;

        // 2 - use direct merge function
        Integer[] result = new Integer[arr1.length + arr2.length];

        Integer[] longArr;
        Integer[] shortArr;

        if (arr1.length <= arr2.length) {
            shortArr = arr1;
            longArr = arr2;
        } else {
            shortArr = arr2;
            longArr = arr1;
        }

        int i = 0;
        int j = 0;
        int k = 0;
        for (; i < shortArr.length && j < longArr.length; k++) {
//        for (int i = 0, j = 0, k = 0; i < shortArr.length && j < longArr.length; k++) {
            if (shortArr[i] <= longArr[j]) {
                result[k] = shortArr[i];
                i++;
                System.out.println("short, i = " + i + ", k = " + k);
            } else {
                result[k] = longArr[j];
                j++;
                System.out.println("long, j = " + j + ", k = " + k);
            }
        }

        // Copy remaining elements of shortArr[] if any
        while (i < shortArr.length) {
            result[k] = shortArr[i];
            i++;
            k++;
            System.out.println("short appendix, i = " + i + ", k = " + k);
        }
        // Copy remaining elements of longArr[] if any
        while (j < longArr.length) {
            result[k] = longArr[j];
            j++;
            k++;
            System.out.println("long appendix, j = " + j + ", k = " + k);
        }
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
