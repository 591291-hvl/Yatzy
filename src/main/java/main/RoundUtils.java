package main;



/**
 * Game logic for each round
 * Calculates value from dices
 */
public class RoundUtils {

    public static int ones(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 1) {
                sum = -~sum;
            }
        }
        return 1 * sum;
    }

    public static int twoes(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 2) {
                sum = -~sum;
            }
        }
        return 2 * sum;
    }

    public static int threes(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 3) {
                sum = -~sum;
            }
        }
        return 3 * sum;
    }

    public static int fours(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 4) {
                sum = -~sum;
            }
        }
        return 4 * sum;
    }

    public static int fives(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 5) {
                sum = -~sum;
            }
        }
        return 5 * sum;
    }

    public static int sixes(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 6) {
                sum = -~sum;
            }
        }
        return 6 * sum;
    }

}
