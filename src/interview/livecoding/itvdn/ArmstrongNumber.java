package interview.livecoding.itvdn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArmstrongNumber {

    public static void main(String[] args) {
        System.out.println(isArmstrongNumber(123));

        System.out.println(isArmstrongNumber(371));
        System.out.println(isArmstrongNumber(8208));
    }

    // 371 = 3*3*3 + 7*7*7 + 1*1*1 = 27 + 343 + 1 = 371
    // 8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8 = 4096 + 16 + 0 + 4096 = 8208
    private static boolean isArmstrongNumber(Integer number) {
        char[] chars = String.valueOf(number).toCharArray();
        List<Character> charsList = new ArrayList<>();
        for (char c : chars) {
            charsList.add(c);
        }
        List<Integer> digits = charsList.stream().map(c -> Integer.parseInt(String.valueOf(c))).collect(Collectors.toList());
        int length = digits.size();

        Integer sum = digits.stream().reduce((accumulator, digit) -> accumulator + (int) Math.pow(Double.valueOf(digit), length)).get();
        return sum.equals(number);
    }

}
