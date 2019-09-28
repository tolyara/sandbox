
public class DeMorganLaws {

    private boolean a = false;
    private boolean b = false;

    void checkDeMorganLaws() {

        System.out.println("Checking deMorgan laws, all positions must be true...");
        System.out.println();

        System.out.println(checkFirstLaw(a,b));
        System.out.println(checkSecondLaw(a,b));
        System.out.println();

        System.out.println(checkFirstLaw(a,true));
        System.out.println(checkSecondLaw(a,true));
        System.out.println();

        System.out.println(checkFirstLaw(true,b));
        System.out.println(checkSecondLaw(true,b));
        System.out.println();

        System.out.println(checkFirstLaw(true,true));
        System.out.println(checkSecondLaw(true,true));
        System.out.println();

    }

    private boolean checkFirstLaw(boolean a, boolean b) {

        return !(a && b) == (!a || !b);

    }

    private boolean checkSecondLaw(boolean a, boolean b) {

        return !(a || b) == (!a && !b);

    }

}
