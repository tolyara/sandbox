package interview.programania;

public class Lambdas {

    public static void main(String[] args) {
//        printLength((String str) -> {return str.length();});
//        printLength(str -> str.length());
        printLength(String::length);
    }

    static void printLength(I i) {
        System.out.println(i.getLength("privat"));
    }

}

@FunctionalInterface
interface I {
    int getLength(String s);
}
