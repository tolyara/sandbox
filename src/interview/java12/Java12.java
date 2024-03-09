package interview.java12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.baeldung.com/java-12-new-features
 */
public class Java12 {

    public static final String FILE_1_TXT = "file1.txt";
    public static final String FILE_2_TXT = "file2.txt";

    public static void main(String[] args) throws IOException {
//        indentation();
//        transform();
//        mismatch();
//        teeing();
//        compactNumberFormatting();

//        preview_switchExpression();
        preview_patternMatchingForInstanceOf();
    }

    private static void indentation() {
        String text = "Hello Baeldung!\nThis is Java 12 article.";

        /*
            If the parameter is greater than zero, new spaces will be inserted at the beginning of each line
         */
        text = text.indent(4);
        System.out.println(text);

        /*
            If the parameter is less than zero, it removes spaces from the begging of each line.
            If a given line does not contain sufficient white space, then all leading white space characters are removed.
        */
//        text = text.indent(-10);
//        System.out.println(text);

        text = text.indent(-3);
        System.out.println(text);
    }

    private static void transform() {
        String text = "Baeldung";

//        String transformed = text.transform(value ->
//                new StringBuilder(value).reverse().toString()
//        );
        CustomString transformed = text.transform(CustomString::new);

        System.out.println(transformed);
    }

    private static void mismatch() throws IOException {
//        Path filePath1 = Files.createTempFile("file1", ".txt");
//        Path filePath2 = Files.createTempFile("file2", ".txt");

        Path path1 = Paths.get(FILE_1_TXT);
        Path path2 = Paths.get(FILE_2_TXT);

        Path filePath1 = !Files.exists(path1) ? Files.createFile(path1) : path1;
        Path filePath2 = !Files.exists(path2) ? Files.createFile(path2) : path2;

        /*
            1) The return value will be -1L if the files are identical
         */
//        Files.writeString(filePath1, "Java 12 Article");
//        Files.writeString(filePath2, "Java 12 Article");

        /*
            2) The return value will be the position of the first mismatched byte if the files are not identical
         */
//        Files.writeString(filePath1, "Java 12 Article");
//        Files.writeString(filePath2, "Java 12 Tutorial");

        /*
            3) The return value will be the size of the smaller file (in bytes) when the files are of different sizes
            and every byte of the smaller file is identical to the corresponding byte of the larger file.
         */
        Files.writeString(filePath1, "Java 12");
        Files.writeString(filePath2, "Java 12 Tutorial");

        long mismatch = Files.mismatch(filePath1, filePath2);
        System.out.println(mismatch);

        Files.delete(path1);
        Files.delete(path2);
    }

    private static void teeing() {
//        double average = Stream.of(1, 2, 3, 4, 5)    // -> 3
        double average = Stream.of(6, 17, 20, 1)       // -> 11
                .collect(Collectors.teeing(
                        Collectors.summingDouble(i -> i),
                        Collectors.counting(),
                        (sum, count) -> sum / count));
        System.out.println(average);
    }

    private static void compactNumberFormatting() {
        NumberFormat likesShort =
                NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
        likesShort.setMaximumFractionDigits(2);
        System.out.println(likesShort.format(2592)); // "2.59K"

        NumberFormat likesLong =
                NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
        likesLong.setMaximumFractionDigits(2);
        System.out.println(likesLong.format(2592));  // "2.59 thousand"
    }

    private static void preview_switchExpression() {
        DayOfWeek dayOfWeek = LocalDateTime.now().getDayOfWeek();
        String typeOfDay = "";

//        switch (dayOfWeek) {
//            case MONDAY:
//            case TUESDAY:
//            case WEDNESDAY:
//            case THURSDAY:
//            case FRIDAY:
//                typeOfDay = "Working Day";
//                break;
//            case SATURDAY:
//            case SUNDAY:
//                typeOfDay = "Day Off";
//        }

        typeOfDay = switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Working Day";
            case SATURDAY, SUNDAY -> "Day Off";
        };

        System.out.println(typeOfDay);
    }

    private static void preview_patternMatchingForInstanceOf() {
        long millis = System.currentTimeMillis();
        System.out.println(millis);
        Object obj;
        long leftover = millis % 3;
        if (leftover == 0) {
            obj = "Hello World";
        } else if (leftover == 1) {
            obj = millis;
        } else {
            obj = new Object();
        }
        String result;

//        if (obj instanceof String) {
//            String s = (String) obj;
//            int length = s.length();
//        }

        if (obj instanceof String s) {
            result = "String type, length = " + s.length();
        } else if (obj instanceof Long l) {
            result = "Long type, odd/even = " + ((l % 2 == 0) ? "even" : "odd");
        } else {
            result = "Object type";
        }
        System.out.println(result);
    }

}

class CustomString {
    private final String customValue;

    CustomString(String customValue) {
        this.customValue = customValue;
    }

    @Override
    public String toString() {
        return "CustomString{" +
                "customValue='" + customValue + '\'' +
                '}';
    }
}
