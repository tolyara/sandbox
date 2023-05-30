package interview.livecoding;

import java.util.Map;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        var bundle = Map.of(
                "fl", new String[]{"flower", "flow", "flight"},
                "prog", new String[]{"progenitive", "prognathouse", "prognosis"},
                "", new String[]{"dog", "racecar", "car"},
                "java", new String[]{"java_9", "java", "java_11", "java_17"},
                "windows", new String[]{"windows", "windows_10", "windows_11"},
                "win", new String[]{"windows", "windows_10", "win_11"},
                "duplicate", new String[]{"duplicate", "duplicate"},
                "Passed", new String[]{"Passed"}

//                "fl", new String[]{"flower", "flow", "flight"}
//                "java", new String[]{"java_9", "java", "java_11", "java_17"}
                );
        bundle.forEach((k, v) -> {
            var result = getLongestCommonPrefix(v);
            System.out.println("(" + (k.equals(result) ? "+" : "-") + ") " + k + " -> " + result );
        });
    }

    private static String getLongestCommonPrefix(String[] values) {
        StringBuilder result = new StringBuilder();

        int minLength = values[0].length();
        for (int i = 1; i < values.length; i++) {
            if (values[i].length() < minLength) {
                minLength = values[i].length();
            }
        }
//        System.out.println(minLength);

        if (minLength > 0) {
            for (int i = 0; i < minLength; i++) {   // char's index loop
                char c = values[0].charAt(i);
                boolean matched = true;
                for (int j = 1; j < values.length; j++) {
//                    System.out.println(values[j] + " " + i + " " + j);
                    if (values[j].charAt(i) != c) {
                        matched = false;
                        break;
                    }
                }
                if (matched) {
//                    System.out.println("matched -> " + c);
                    result.append(c);
                } else {
//                    System.out.println("not matched");
                    break;
                }
            }
        }

        return result.toString();
    }

}
