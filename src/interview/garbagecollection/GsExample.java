package interview.garbagecollection;

public class GsExample {

    public static void main(String[] args) throws Exception {
        referToAnotherObject();
//        islandsOfIsolation();
    }

    private static void referToAnotherObject() {
        GsTest str1 = new GsTest("111");
        GsTest str2 = new GsTest("222");
        //String object referred by str1 is not eligible for GC yet

        str1 = str2;
        /* Now the str1 variable referes to the String object "Another String" and the object "Garbage collected after use" is not referred by any variable and hence is eligible for GC */

        Runtime.getRuntime().gc();
    }

    private static void islandsOfIsolation() throws InterruptedException {
        GsTest gc1 = new GsTest("111");
        GsTest gc2 = new GsTest("222");
        gc1.g = gc2; //gc1 refers to gc2
        gc2.g = gc1; //gc2 refers to gc1

        gc1 = null;
        gc2 = null;

        //gc1 and gc2 refer to each other and have no other valid //references
        //gc1 and gc2 form Island of Isolation
        //gc1 and gc2 are eligible for Garbage collection here

//        Thread.sleep(10);
        System.gc();
    }

}

class GsTest {

    GsTest g;

    String text;

    public GsTest() {}

    public GsTest(String text) {
        this.text = text;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println((this.text != null ? text : this) + " finalized");
//        super.finalize();
    }

}
