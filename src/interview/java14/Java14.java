package interview.java14;

/**
 * https://www.baeldung.com/java-14-new-features
 */
public class Java14 {

    public static void main(String[] args) {
//        switchExpressions();
//        textBlocks();
//        preview_patternMatchingForInstanceOf("123456");
        records();
    }

    private static void switchExpressions() {
        String day = "WEDNESDAY";
//        String day = "SATURDAY";
//        String day = "bla";

        boolean isTodayHoliday  = switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> false;
            case "SATURDAY", "SUNDAY" -> true;
            default -> throw new IllegalArgumentException("What's a " + day);
        };

        System.out.println(isTodayHoliday);
    }

    /*
        In second preview, text blocks now have two new escape sequences:

        \: to indicate the end of the line, so that a new line character is not introduced
        \s: to indicate a single space
     */
    private static void textBlocks() {
//        String multiline = "A quick brown fox jumps over a lazy dog; the lazy dog howls loudly.";

//        String multiline = """
//                A quick brown fox jumps over a lazy dog; \
//                the lazy dog howls loudly.""";

        String multiline = """
                A quick brown fox \s jumps over a lazy dog;""";

        System.out.println(multiline);
    }

    private static void preview_patternMatchingForInstanceOf(Object obj) {
        if (obj instanceof String str) {
            int len = str.length();
            System.out.println(len);
        }
    }

    private static void records() {
        User user1 = new User(1, "UserOne");
        User user2 = new User(2, "UserTwo");
        User user1copy = new User(1, "UserOne");

        System.out.println(user1.id());
        System.out.println(user1.username());
        System.out.println(user1.hashCode());
        System.out.println(user1);

        System.out.println(user1.equals(user2));    // false
        System.out.println(user1.equals(user1copy));    // true
    }

}

/*
    This simple declaration will automatically add a constructor, getters, equals, hashCode and toString methods for us.
 */
record User(int id, String username) {
};

