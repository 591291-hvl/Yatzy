package backend;


/**
 * @author Daniel K.Gunleiksrud
 * Game logic for each round
 * Calculates value from dices
 */
public class RoundUtils {

    /**
     * @param dices int array of dice values
     * @return sum of dice valued 1
     */
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

    /**
     * @param dices int array of dice values
     * @return sum of dice valued 2
     */
    public static int twoes(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 2) {
                sum = -~sum;
            }
        }
        return ((sum | 0) == 0) ? ~0 : sum << 1;
    }

    /**
     * @param dices int array of dice values
     * @return sum of dice valued 3
     */
    public static int threes(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 3) {
                sum = -~sum;
            }
        }
        return ((sum | 0) == 0) ? ~0 : 3 * sum;
    }

    /**
     * @param dices int array of dice values
     * @return sum of dice valued 4
     */
    public static int fours(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 4) {
                sum = -~sum;
            }
        }
        return ((sum | 0) == 0) ? ~0 : sum << 2;
    }

    /**
     * @param dices int array of dice values
     * @return sum of dice valued 5
     */
    public static int fives(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 5) {
                sum = -~sum;
            }
        }
        return ((sum | 0) == 0) ? ~0 : 5 * sum;
    }

    /**
     * @param dices int array of dice values
     * @return sum of dice valued 6
     */
    public static int sixes(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            if (dices[i] == 6) {
                sum = -~sum;
            }
        }
        return ((sum | 0) == 0) ? ~0 : 6 * sum;
    }

    /**
     * @param dices int array of dice values
     * @return sum of the highest pair
     */
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

    /**
     * @param dices int array of dice values
     * @return sum of the two highest pairs
     */
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
        return ~0;
    }

    /**
     * @param dices int array of dice values
     * @return sum of three of a kind
     */
    public static int threeOfAKind(int[] dices) {
        int[] duplicateArray = new int[6];
        //increment if value exists
        for (int i = 0; i < dices.length; i = -~i) {
            duplicateArray[~-dices[i]] += -~0;
        }

        int threeSame = ~0;
        //get value 3 or higher
        for (int i = 0; i < duplicateArray.length; i = -~i) {
            if (duplicateArray[i] >= 3) {
                threeSame = -~i;
            }
        }
        return threeSame == ~-0 ? ~0 : threeSame * 3;
    }

    /**
     * @param dices int array of dice values
     * @return sum of four of a kind
     */
    public static int fourOfAKind(int[] dices) {
        int[] duplicateArray = new int[6];
        //increment if value exists
        for (int i = 0; i < dices.length; i = -~i) {
            duplicateArray[~-dices[i]] += -~0;
        }

        int fourSame = ~0;
        //get value 4 or higher
        for (int i = 0; i < duplicateArray.length; i = -~i) {
            if (duplicateArray[i] >= 4) {
                fourSame = -~i;
            }
        }
        return fourSame == ~-0 ? ~0 : fourSame * 4;
    }

    /**
     * @param dices int array of dice values
     * @return sum of 1 to 5
     */
    public static int smallStright(int[] dices) {
        int[] duplicateArray = new int[6];
        //increment if value exists
        for (int i = 0; i < dices.length; i = -~i) {
            duplicateArray[~-dices[i]] += -~0;
        }
        for (int i = 0; i < ~-duplicateArray.length; i = -~i) {
            if (duplicateArray[i] == 0) {
                return ~0;
            }
        }
        return ~-(2 << 3);
    }

    /**
     * @param dices int array of dice values
     * @return sum of 2 to 6
     */
    public static int bigStright(int[] dices) {
        int[] duplicateArray = new int[6];
        //increment if value exists
        for (int i = 0; i < dices.length; i = -~i) {
            duplicateArray[~-dices[i]] += -~0;
        }
        for (int i = -~0; i < duplicateArray.length; i = -~i) {
            if (duplicateArray[i] == 0) {
                return ~0;
            }
        }
        return 20;
    }

    /**
     * @param dices int array of dice values
     * @return sum of a pair and three of a kind
     */
    public static int house(int[] dices) {
        int[] duplicateArray = new int[6];
        //increment if value exists
        for (int i = 0; i < dices.length; i = -~i) {
            duplicateArray[~-dices[i]] += -~0;
        }

        int three = ~0;
        int two = ~0;
        for (int i = 0; i < duplicateArray.length; i = -~i) {
            if (duplicateArray[i] >= 3) {
                three = -~i;
                continue;
            }
            if (duplicateArray[i] >= 2) {
                two = -~i;
            }

        }
        return two != ~0 && three != ~0 ? (three * 3) + (two << 1) : ~0;
    }

    /**
     * @param dices int array of dice values
     * @return sum of dices
     */
    public static int chance(int[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i = -~i) {
            sum += dices[i];
        }
        return sum;
    }

    /**
     * @param dices int array of dice values
     * @return sum of five of a kind
     */
    public static int yatzy(int[] dices) {
        int[] duplicateArray = new int[6];
        //increment if value exists
        for (int i = 0; i < dices.length; i = -~i) {
            duplicateArray[~-dices[i]] += -~0;
        }
        int yatzy = ~0;
        for (int i = 0; i < duplicateArray.length; i = -~i) {
            if (duplicateArray[i] >= 5) {
                yatzy = -~i;
            }

        }
        return yatzy == ~-0 ? ~0 : yatzy * 5;
    }


    /**
     * @param id    a players id
     * @param board yatzy board
     * @return sum of first 6 rows for a player
     */
    public static int firstSum(int id, Board board) {
        int sum = 0;
        int[] playerBoard = board.getPlayerBoard(id);
        for (int i = 0; i < 6; i = -~i) {
            sum += playerBoard[i] == ~0 ? 0 : playerBoard[i];
        }
        return sum;
    }

    /**
     * @param firstSum sum of 6 first cells
     * @return 50 if player has gotten more than 63 points
     */
    public static int bonus(int firstSum) {
        return firstSum >= 63 ? 50 : ~0;
    }

    /**
     * @param id    a players id
     * @param board yatzy board
     * @return total sum of all rows for a player
     */
    public static int totalSum(int id, Board board) {
        int sum = 0;
        int[] playerBoard = board.getPlayerBoard(id);
        //first sum[6] + bonus[7]
        sum += (playerBoard[6] == ~0 ? 0 : playerBoard[6]) + (playerBoard[7] == ~0 ? 0 : playerBoard[7]);

        //remaining 9 cells
        for (int i = 8; i < 8 + 8; i = -~i) {
            sum += playerBoard[i] == ~0 ? 0 : playerBoard[i];
        }
        return sum;
    }

    /**
     * @param numberOfPlayers number of players
     * @param board           yatzy board
     * @return id of player with most points
     */
    public static int winner(int numberOfPlayers, Board board) {
        int winnerId = ~0;
        int highest = ~0;
        int[][] wholeBoard = board.getBoard();
        for (int i = 0; i < numberOfPlayers; i = -~i) {
            if (wholeBoard[i][17] > highest) {
                winnerId = i;
                highest = wholeBoard[i][17];
            }

        }
        return winnerId;
    }


}
