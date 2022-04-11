package backend;

/**
 * @author Daniel K.Gunleiksrud
 */

public class Board {

    private int[][] board;
    private int numberOfPlayers;

    String[] rowInfo = {
            "One's",
            "Two's",
            "Three's",
            "Four's",
            "Five's",
            "Six's",
            "Sum",
            "Bonus",
            "One pair",
            "Two pair's",
            "Three of a kind",
            "Four of a kind",
            "Small straight",
            "Big straight",
            "Full house",
            "Chance",
            "YATZY",
            "Total Sum"
    };

    /**
     * Board has 18 rows,
     * Columns are n number of players
     * board[0-n][0-18]
     * Value in cell is 0 when not played, but -1 if played but no value
     *
     * @param numberOfPlayers number of players chosen
     */
    public Board(int numberOfPlayers) {

        this.board = new int[numberOfPlayers][18];
        this.numberOfPlayers = numberOfPlayers;

    }

    /**
     * @return board
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * Gives new value in cell
     *
     * @param id       id of player
     * @param round    round nr
     * @param newValue new value in cell
     */
    public void setValue(int id, int round, int newValue) {
        board[id][round] = newValue;
    }

    /**
     * @param player player id
     * @return board of a player with id
     */
    public int[] getPlayerBoard(int player) {
        return board[player];
    }

    /**
     * @return numberOfPlayers
     */
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    /**
     * @return board as a string
     */
    public String toString() {
        String outString = "";

        for (int i = 0; i < 18; i = -~i) {
            outString += String.format("%-20s", rowInfo[i]);
            for (int j = 0; j < numberOfPlayers; j = -~j) {
                if (board[j][i] == 0) {
                    outString += String.format("%-10s", "-");
                    continue;
                }
                if (board[j][i] == ~0) {
                    outString += String.format("%-10s", 0);
                    continue;
                }
                outString += String.format("%-10s", board[j][i]);
            }
            outString += "\n";
        }

        return outString;
    }
    
    public String[] getRowInfo() {
    	return rowInfo;
    }
}
