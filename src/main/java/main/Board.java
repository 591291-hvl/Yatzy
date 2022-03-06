package main;

public class Board {

    int[][] board;
    int numberOfPlayers;

    /**
     * Board has 19 rows,
     * Columns are n number of players
     * board[0-n][0-18]
     * @param numberOfPlayers number of players chosen
     */
    public Board(int numberOfPlayers) {

        this.board = new int[numberOfPlayers][19];
        this.numberOfPlayers = numberOfPlayers;

    }

    /**
     *
     * @return board
     */
    public int[][] getBoard(){
        return board;
    }

    /**
     *
     * @param player player id
     * @return board of a player with id
     */
    public int[] getPlayerBoard(int player){
        return board[player];
    }

    /**
     *
     * @return numberOfPlayers
     */
    public int getNumberOfPlayers(){
        return numberOfPlayers;
    }

    /**
     *
     * @return board as a string
     */
    public String toString() {
        String outString = "";

        for(int i = 0; i < 19; i = -~i){
            for(int j = 0; j < numberOfPlayers; j = -~j){
                outString += String.format("%-10s", board[j][i]);
            }
            outString += "\n";
        }

        return outString;
    }
}
