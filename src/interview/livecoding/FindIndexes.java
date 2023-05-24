package interview.livecoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIndexes {

    public static void main(String[] args) {
//        List<Integer> list = List.of(-4, 0, 2, null, 17, 22, null, 2, 2, 17);     // NPE
        List<Integer> list = Arrays.asList(-4, 0, 2, null, 17, 22, null, 2, 2, 17);

        List<Integer> result = findIndexes(2, list);

        System.out.println(result);
    }

    public static List<Integer> findIndexes(Integer value, List<Integer> source) {
        List<Integer> result = new ArrayList<>();



        return result;
    }

}
