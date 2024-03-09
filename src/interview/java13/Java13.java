package interview.java13;

/**
 * https://www.baeldung.com/java-13-new-features
 */
public class Java13 {

    public static void main(String[] args) {
//        switchExpressions();
        textBlocks();
    }

    private static void switchExpressions() {
        var me = 4;
        var operation = "squareMe";
//        var operation = "doubleMe";
//        var operation = "meme";

        var result = switch (operation) {
            case "doubleMe" -> {
                System.out.println("logging doubleMe ... ");
                yield me * 2;
            }
            case "squareMe" -> {
                System.out.println("logging squareMe ... ");
                yield me * me;
            }
            default -> {
                System.out.println("logging default ... ");
                yield me;
            }
        };

        System.out.println(result);
    }

    private static void textBlocks() {
        String JSON_STRING
                = "{\r\n" + "\"name\" : \"Baeldung\",\r\n" + "\"website\" : \"https://www.%s.com/\"\r\n" + "}";

        String TEXT_BLOCK_JSON = """
                {
                    "name" : "Baeldung",
                    "website" : "https://www.%s.com/"
                }
                """;

        System.out.println(JSON_STRING);
        System.out.println();
        System.out.println(TEXT_BLOCK_JSON);
    }

}
