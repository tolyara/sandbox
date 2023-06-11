package interview.livecoding.proglib;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("qwewq"));
        System.out.println(isPalindrome("qwewe"));

//        System.out.println(isPalindrome("qweewq"));
//        System.out.println(isPalindrome("qweewe"));

    }

    private static boolean isPalindrome(String s) {
        boolean result = true;

        char[] chars = s.toCharArray();
        System.out.println(chars.length / 2);
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                result = false;
            }
        }
        return result;
    }

}
