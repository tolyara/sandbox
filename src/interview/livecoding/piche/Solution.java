package interview.livecoding.piche;

public class Solution {

    public static void main(String[] args) {
        MathOperations mo = new MathOperations();

        System.out.println(mo.add(4, 7));
        System.out.println(mo.substract(4, 7));
        System.out.println(mo.multiply(4, 7));
        System.out.println(mo.divide(4, 7));

        System.out.println(MathOperations.power(3, 4));

        System.out.println(mo.applyOperation(17, 44, new CustomOperation()));
    }

}

class MathOperations {

    public int add(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        double ad = a;
        double bd = b;
        return ad / bd;
    }

    public static double power(int base, int exponent) {
        return Math.pow(base, exponent);
    }

    public double applyOperation(int a, int b, Operation operation) {
        return operation.operate(a, b);
    }

}

interface Operation {

    int operate(int a, int b);

}

class CustomOperation implements Operation {

    /*
        concatenating a and b as strings and converting back to an integer
     */
    @Override
    public int operate(int a, int b) {
        String s = "" + a + b;
        return Integer.parseInt(s);
    }

}