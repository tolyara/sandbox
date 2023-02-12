package interview.programania;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-3);
        list.add(8);
        list.add(12);
        list.add(-8);
        list.add(0);
        list.add(5);
        list.add(10);
        list.add(1);
        list.add(150);
        list.add(-30);
        list.add(19);

        Collections.sort(list);
//        int index = Collections.binarySearch(list, 12);  // should be 8
        int index = Collections.binarySearch(list, 100);  // should not be found
        System.out.println(index);

        System.out.println();
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }

}


