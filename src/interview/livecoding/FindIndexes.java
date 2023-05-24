package interview.livecoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIndexes {

    public static void main(String[] args) {
//        List<Integer> list = List.of(-4, 0, 2, null, 17, 22, null, 2, 2, 17);     // NPE
        List<Integer> list = Arrays.asList(-4, 0, 2, null, 17, 22, null, 2, 2, 17);

//        List<Integer> result = findIndexes(2, null);

        List<Integer> result = findIndexes(null, list);
//        List<Integer> result = findIndexes(2, list);
//        List<Integer> result = findIndexes(17, list);

        System.out.println(result);
    }

    public static List<Integer> findIndexes(Integer value, List<Integer> source) {
        List<Integer> result = new ArrayList<>();

        if (source != null) {
            for (int i = 0; i < source.size(); i++) {
                Integer e = source.get(i);
                if (value == null && e == null || e != null && e.equals(value)) {
                    result.add(i);
                }
            }
        }

        return result;
    }

}
