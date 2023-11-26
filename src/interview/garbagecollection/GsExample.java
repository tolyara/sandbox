package interview.garbagecollection;

public class GsExample {

    public static void main(String[] args) throws Exception {
        islandsOfIsolation();
    }

    private static void islandsOfIsolation() throws InterruptedException {
        GsTest gc1 = new GsTest();
        GsTest gc2 = new GsTest();
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

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this + " finalized");
//        super.finalize();
    }

}
