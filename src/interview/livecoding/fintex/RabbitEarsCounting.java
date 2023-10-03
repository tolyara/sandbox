package interview.livecoding.fintex;

public class RabbitEarsCounting {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countEars2(n));
    }

    private static int countEars(int rabbits) {
        return rabbits * 2;
    }

    private static int countEars2(int rabbits) {
        int result = 0;

        if (rabbits == 1) {
            return 2;
        }
        result = (2 + countEars2(rabbits - 1));
        return result;
    }

}
