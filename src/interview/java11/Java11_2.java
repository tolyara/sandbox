package interview.java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *  https://www.baeldung.com/java-11-new-features
 */
public class Java11_2 {

    public static void main(String[] args) throws Exception {
//        stringMethods();
//        fileMethods();
//        collectionToArray();
//        notPredicate();
//        localVarSyntax();
//        httpClient();
        nestBasedAccessControl();
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

    private static void httpClient() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
//                .uri(URI.create("http://localhost:" + port))
                .uri(URI.create("http://www.google.com"))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.body());
    }

    private static void nestBasedAccessControl() {
        System.out.println(MainClass.class.isNestmateOf(MainClass.NestedClass.class));  // true
        System.out.println(MainClass.class.isNestmateOf(MainClass2.class) + "\n");  // false

        System.out.println(MainClass.NestedClass.class.getNestHost().getSimpleName() + "\n");  // MainClass

        Set<String> nestedMembers = Arrays.stream(MainClass.NestedClass.class.getNestMembers())
                .map(Class::getSimpleName)
                .collect(Collectors.toSet());
        System.out.println(nestedMembers);
    }

    private static void runningJavaFiles() {
        /*
            A major change in this version is that we don’t need to compile the Java source files with javac explicitly anymore

            $ javac HelloWorld.java
            $ java HelloWorld
            Hello Java 8!

            Instead, we can directly run the file using the java command:

            $ java HelloWorld.java
            Hello Java 11!
         */
    }

}

class MainClass {

    class NestedClass {}

}

class MainClass2 {
}
