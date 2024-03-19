package interview.java14;

public class Java14 {

    public static void main(String[] args) {
        switchExpressions();
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

}
