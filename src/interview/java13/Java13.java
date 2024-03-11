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

//        System.out.println(JSON_STRING);
//        System.out.println();
//        System.out.println(TEXT_BLOCK_JSON);

        System.out.println();
        String TEXT_BLOCK_JSON_2 = """
                {
                    "name" :    "Baeldung",
                    "website" : "https://www.%s.com/"
                }
                """;
        TEXT_BLOCK_JSON_2 = TEXT_BLOCK_JSON_2.indent(4);
        TEXT_BLOCK_JSON_2 = TEXT_BLOCK_JSON_2.indent(-4);
//        TEXT_BLOCK_JSON_2 = TEXT_BLOCK_JSON_2.stripIndent();  // Note: doesn't work as expected
//        System.out.println(TEXT_BLOCK_JSON_2);

        /*
            translateEscapes() – translates escape sequences such as “\\t” to “\t”
         */
        String JSON_STRING_2 = """ 
                Hello,\\nuser""";
//        System.out.println(JSON_STRING_2);
//        System.out.println();
//        System.out.println(JSON_STRING_2.translateEscapes());

        /*
            formatted() – works the same as String::format, but for text blocks
         */
        System.out.println(TEXT_BLOCK_JSON);
        System.out.println(TEXT_BLOCK_JSON.formatted("baeldung"));
    }

}
