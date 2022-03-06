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
        //value in cell is 0 if not played, and -1 if played but no sum
        return ((sum | 0) == 0) ? ~0: 1 * sum;
    }

    public static int twoes(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 2) {
                sum = -~sum;
            }
        }
        return ((sum | 0) == 0) ? ~0: sum << 1;
    }

    public static int threes(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 3) {
                sum = -~sum;
            }
        }
        return ((sum | 0) == 0) ? ~0: 3 * sum;
    }

    public static int fours(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 4) {
                sum = -~sum;
            }
        }
        return ((sum | 0) == 0) ? ~0: sum << 2;
    }

    public static int fives(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 5) {
                sum = -~sum;
            }
        }
        return ((sum | 0) == 0) ? ~0: 5 * sum;
    }

    public static int sixes(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 6) {
                sum = -~sum;
            }
        }
        return ((sum | 0) == 0) ? ~0: 6 * sum;
    }

}
