package interview.java11;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Java11 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        JEP_323_Local_Variable_Syntax_for_Lambda_Parameters();

//        JEP_String_isBlank();
//        JEP_String_lines();
//        JEP_String_repeat();
        JEP_String_strip();
    }

    private static void JEP_323_Local_Variable_Syntax_for_Lambda_Parameters() {
        List<String> list = List.of("Tony", "LUK", "bobby");
        List<String> result = list.stream()
                .map((@NotNull var s) -> s.toLowerCase())
//                .map((@NotNull s) -> s.toLowerCase())         // compile error
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private static void JEP_String_isBlank() {
        String s1 = "";
        String s2 = "   ";
        String s3 = " Q ";
        System.out.println(s1.isBlank() + " " + s2.isBlank()  + " " + s3.isBlank());
    }

    private static void JEP_String_lines() {
        String s1 = "first second third";
        String s2 = "first\n" +
                "second\n" +
                "third\n";
        List<String> list1 = s1.lines().collect(Collectors.toList());
        List<String> list2 = s2.lines().collect(Collectors.toList());

        System.out.println(list1 + ", size = " + list1.size());
        System.out.println(list2 + ", size = " + list2.size());
    }

    private static void JEP_String_repeat() {
        String s1 = "repeat";
        String res = s1.repeat(4);
        System.out.println(res);
    }

    private static void JEP_String_strip() {
        char c = '\u2000';
        String s = c + "abc" + c;

        System.out.println(Character.isWhitespace(c));
        System.out.println(s.trim());
        System.out.println(s.strip());
    }

}

@interface NotNull {
}
