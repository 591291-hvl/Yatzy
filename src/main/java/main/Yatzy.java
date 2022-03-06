package main;


public class Yatzy {

    DiceShaker shaker;
    Player players;
    Board board;

    int numberOfDices;
    int numberOfPlayers;

    /**
     * Initializes classes to use in game
     * @param numberOfDices number of dices to play by
     * @param numberOfPlayers number of players:)
     */
    public Yatzy(int numberOfDices, int numberOfPlayers){
        //create dice shaker, option to choose number of dices
        this.shaker = new DiceShaker(numberOfDices);
        this.numberOfDices = numberOfDices;
        this.numberOfPlayers = numberOfPlayers;

        //players
        this.players = new Player(numberOfPlayers);

        //board
        this.board = new Board(numberOfPlayers);


    }

    /**
     * prints how the board looks like in console
     */
    public void display(){
        String stringBoard = "";
        int[] playerId = players.getPlayers();
        for (int i = 0; i < numberOfPlayers; i = -~i){
            stringBoard += String.format("%-10s", playerId[i]);
        }
        stringBoard += "\n" + board.toString();

        System.out.println(stringBoard);
    }


}
