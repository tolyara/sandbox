package interview.java11;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Java11 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        JEP_323_Local_Variable_Syntax_for_Lambda_Parameters();
        JEP_String_isBlank();
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

}

@interface NotNull {
}
