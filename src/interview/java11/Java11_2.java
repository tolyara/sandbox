package interview.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *  https://www.baeldung.com/java-11-new-features
 */
public class Java11_2 {

    public static void main(String[] args) throws IOException {
//        stringMethods();
//        fileMethods();
//        collectionToArray();
//        notPredicate();
        localVarSyntax();
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

    private static void collectionToArray() {
        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        String[] sampleArray = sampleList.toArray(String[]::new);
        Arrays.stream(sampleArray).forEach(System.out::println);
    }

    private static void notPredicate() {
        List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
        List<String> withoutBlanks = sampleList.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        System.out.println(withoutBlanks);
    }

    private static void localVarSyntax() {
//        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        List<String> sampleList = new ArrayList<>();
        sampleList.add("Java");
        sampleList.add("Kotlin");
//        sampleList.add(null);

        String resultString = sampleList.stream()
                .map((@NotNull var x) -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println(resultString);
    }

}
