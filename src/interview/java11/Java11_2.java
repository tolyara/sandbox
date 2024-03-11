package interview.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  https://www.baeldung.com/java-11-new-features
 */
public class Java11_2 {

    public static void main(String[] args) throws IOException {
//        stringMethods();
        fileMethods();
    }

    private static void stringMethods() {
        String multilineString = "Baeldung helps \n \n developers \n explore Java.";
        System.out.println(multilineString);
        System.out.println();

        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());
        System.out.println(lines);
    }

    private static void fileMethods() throws IOException {
        Path filePath = Files.writeString(Files.createTempFile("demo", ".txt"), "Sample text");
        String fileContent = Files.readString(filePath);
        System.out.println(fileContent.equals("Sample text"));
    }

}
