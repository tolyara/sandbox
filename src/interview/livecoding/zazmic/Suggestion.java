package interview.livecoding.zazmic;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'getProductSuggestions' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY products
     *  2. STRING search
     */

    public static List<List<String>> getProductSuggestions(List<String> products, String search) {
        List<List<String>> result = new ArrayList<>();
        List<String> matches = new ArrayList<>();
        List<String> smallestThree = new ArrayList<>();

        for (String product : products) {
            if (product.startsWith(search)) {
                matches.add(product);
            }
        }
//        smallestThree = matches.stream().sorted().limit(3).collect(Collectors.toList());

        result.add(matches);
        result.add(smallestThree);
        return result;
    }

}
public class Suggestion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int productsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> products = IntStream.range(0, productsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        String search = bufferedReader.readLine();

        List<List<String>> result = Result.getProductSuggestions(products, search);

        result.stream()
                .map(
                        r -> r.stream()
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

