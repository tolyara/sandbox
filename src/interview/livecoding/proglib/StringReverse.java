package interview.livecoding.proglib;

public class StringReverse {

    public static void main(String[] args) {
        String string = "Java test";
        System.out.println(reverseByArray(string));
    }

    private static String reverseByArray(String s) {
        char[] source = s.toCharArray();
        char[] result = new char[source.length];
        for (int i = 0; i < source.length; i++) {
            result[(source.length - 1) - i] = source[i];
//            System.out.println(result);
        }
        return new String(result);
    }

}
