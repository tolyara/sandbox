package interview.livecoding.fintex;

public class TaskSolution {

    public static void main(String[] args) {

        int n = 10;
        System.out.println(countEars2(n));

    }

    private static int countEars(int n) {
        return n * 2;
    }

    private static int countEars2(int n) {
        int result = 0;

        if (n == 1) {
            return 2;
        }
        result = (2 + countEars2(n - 1));
        return result;
    }

}
