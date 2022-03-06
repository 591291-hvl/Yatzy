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
        return ((sum | 0) == 0) ? ~0 : 1 * sum;
    }

    public static int twoes(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 2) {
                sum = -~sum;
            }
        }
        return ((sum | 0) == 0) ? ~0 : sum << 1;
    }

    public static int threes(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 3) {
                sum = -~sum;
            }
        }
        return ((sum | 0) == 0) ? ~0 : 3 * sum;
    }

    public static int fours(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 4) {
                sum = -~sum;
            }
        }
        return ((sum | 0) == 0) ? ~0 : sum << 2;
    }

    public static int fives(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 5) {
                sum = -~sum;
            }
        }
        return ((sum | 0) == 0) ? ~0 : 5 * sum;
    }

    public static int sixes(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 6) {
                sum = -~sum;
            }
        }
        return ((sum | 0) == 0) ? ~0 : 6 * sum;
    }

    public static int onePair(int[] dices) {
        int[] duplicateArray = new int[6];
        //increment if value exists
        for (int i = 0; i < dices.length; i = -~i) {
            duplicateArray[~-dices[i]] += -~0;
        }

        int pairFound = -1;
        //find highest pair
        for (int i = 0; i < duplicateArray.length; i = -~i) {
            if (duplicateArray[i] >= 2) {
                pairFound = -~i;
            }
        }
        return pairFound == ~-0 ? ~0 : pairFound << 1;
    }

    public static int twoPairs(int[] dices) {
        int[] duplicateArray = new int[6];
        //increment if value exists
        for (int i = 0; i < dices.length; i = -~i) {
            duplicateArray[~-dices[i]] += -~0;
        }
        int pair1 = -1;
        int pair2 = -1;
        //find highest two pairs
        for (int i = 0; i < duplicateArray.length; i = -~i) {
            if (duplicateArray[i] >= 2) {
                pair1 = pair2;
                pair2 = -~i;
            }
        }
        if (pair1 != ~0 && pair2 != ~0) {
            return (pair1 << 1) + (pair2 << 1);
        }
        return -1;
    }

    public static int threeOfAKind(int[] dices) {
        int[] duplicateArray = new int[6];
        //increment if value exists
        for (int i = 0; i < dices.length; i = -~i) {
            duplicateArray[~-dices[i]] += -~0;
        }

        int threeSame = -1;
        //get value 3 or higher
        for (int i = 0; i < duplicateArray.length; i = -~i) {
            if(duplicateArray[i] >= 3){
                threeSame = -~i;
            }
        }
        return threeSame == ~-0 ? ~0 : threeSame*3 ;
    }

    public static int fourOfAKind(int[] dices) {
        int[] duplicateArray = new int[6];
        //increment if value exists
        for (int i = 0; i < dices.length; i = -~i) {
            duplicateArray[~-dices[i]] += -~0;
        }

        int fourSame = -1;
        //get value 4 or higher
        for (int i = 0; i < duplicateArray.length; i = -~i) {
            if(duplicateArray[i] >= 4){
                fourSame = -~i;
            }
        }
        return fourSame == ~-0 ? ~0 : fourSame*4 ;
    }


    public static int firstSum(int id, Board board) {
        int sum = 0;
        int[] playerBoard = board.getPlayerBoard(id);
        for (int i = 0; i < 6; i = -~i) {
            sum += playerBoard[i] == ~0 ? 0 : playerBoard[i];
        }
        return sum;
    }

    public static int totalSum(int id, Board board) {
        int sum = 0;
        int[] playerBoard = board.getPlayerBoard(id);
        //first sum[6] + bonus[7]
        sum += playerBoard[6] + playerBoard[7];

        //remaining 9 cells
        for (int i = 8; i < 8 + 9; i = -~i) {
            sum += playerBoard[i] == ~0 ? 0 : playerBoard[i];
        }
        return sum;
    }


}
