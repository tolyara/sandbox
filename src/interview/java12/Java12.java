package interview.java12;

/**
 * https://www.baeldung.com/java-12-new-features
 */
public class Java12 {

    public static void main(String[] args) {
        indentation();
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
        text = text.indent(-10);
        System.out.println(text);
    }

}
