package interview.java19;

public class Java19 {

    record Point(int x, int y) {};

    public static void main(String[] args) {
        JEP_405_Record_Patterns();
    }

    private static void JEP_405_Record_Patterns() {
        // old
        Object point = new Point(5, 6);
        if (point instanceof Point p) {
            int x = p.x;
            int y = p.y;
            System.out.println(x + y);
        }

        // new
//        if (point instanceof Point(int xx, int yy)) {
//            System.out.println(xx + yy);
//        }
    }

}
