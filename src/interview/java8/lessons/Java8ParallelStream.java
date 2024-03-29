package interview.java8.lessons;

import java.util.ArrayList;
import java.util.List;

/**
 *  It is reasonable to use parallel streams when we have a huge amount of elements, otherwise it could even reduce the performance
 */
public class Java8ParallelStream {

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(10.0);
        list.add(5.0);
        list.add(1.0);
        list.add(0.25);

        // correct work, rearranging the terms does not change the sum
//        double result = list.parallelStream().reduce((a, c) -> a + c).get(); // 16.25

        // incorrect work, the quotient depends on the order of the dividends/divider
//        double result = list.parallelStream().reduce((a, c) -> a / c).get(); // 0.5 (10/5 = 2, 1/0.25 = 4, 2/4 = 0.5)
        double result = list.stream().reduce((a, c) -> a / c).get(); // 8.0

        System.out.println(result);
    }

}
