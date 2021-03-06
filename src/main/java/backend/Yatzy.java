package backend;


import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author Daniel K.Gunleiksrud
 */

public class Yatzy {

    private DiceShaker shaker;
    private Player[] players;
    private Board board;

    private int numberOfDices;
    private int numberOfPlayers;

    //when variable becomes false find winner
    private boolean gameActive = false;

    /**
     * Initializes classes to use in game
     *
     * @param numberOfDices   number of dices to play by
     * @param numberOfPlayers number of players:)
     * @param players array of player objects
     */
    public Yatzy(int numberOfDices, int numberOfPlayers, Player[] players) {
        //create dice shaker, option to choose number of dices
        this.shaker = new DiceShaker(numberOfDices);
        this.numberOfDices = numberOfDices;
        this.numberOfPlayers = numberOfPlayers;

        //players
        String[] playerNames = {"Daniel", "Harald", "Per", "Petter"};
        this.players = players;

        //board
        this.board = new Board(numberOfPlayers);
    }
    
    /**
     * used for lazy frontend:)
     */
    public Yatzy(int[][] board) {
    	this.board = new Board(board);
    }
    
    public Board getBoard() {
    	return board;
    }


    /**
     * toString method
     * @return Board as a string:)
     */
    public String toString(){
        String stringBoard = String.format("%-20s", "Players");

        for (int i = 0; i < numberOfPlayers; i = -~i) {
            stringBoard += String.format("%-10s", players[i].getPlayerName());
        }
        stringBoard += "\n" + board.toString();

        return  stringBoard;

    }


    /**
     * Plays round for one player
     *
     * @param id player id
     * @return int[] dice values
     */
    public int[] playPlayerRound(int id) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n" + "Player " + players[id] + "'s turn");

        //roll happens 3 times, ability to keep 2 times
        for (int i = 0; i < 2; i = -~i) {
            //roll and display
            shaker.shakeDice();
            shaker.display();

            //option to keep
            //create int array from sc input
            System.out.println("Write position of dice to keep 0-5, seperated by space");
            int[] diceToLock = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).map(x -> ~-x).toArray();
            //lock dice
            shaker.lockDice(diceToLock);
        }
        System.out.println("Results: ");
        shaker.shakeDice();
        shaker.display();

        //store value
        int[] diceValues = Stream.of(shaker.getDices()).mapToInt(a -> a.getValue()).toArray();

        //dices back in shaker
        shaker.reset();
        return diceValues;
    }

    /**
     * Play one round, each player gets to play
     *
     * @param round round number
     */
    public void playOneRound(int round) {

        for (int i = 0; i < numberOfPlayers; i = -~i) {
            //play round
            int[] diceValues = playPlayerRound(i);

            //logic method
            gameLogic(i, round, diceValues);

            //update totals
            board.setValue(i, 6, RoundUtils.firstSum(i, board));
            board.setValue(i, 17, RoundUtils.totalSum(i, board));

            //display
            //display();
        }
    }

    /**
     * Callable method to play whole game
     */
    public void playGame() {
        //rounds to play 6 + 9

        //first 6 rounds
        for (int i = -~0; i <= 6; i = -~i) {
            playOneRound(i);
        }
        //bonus for each player
        for (int j = 0; j < numberOfPlayers; j = -~j) {
            board.setValue(j, 7, RoundUtils.bonus(RoundUtils.firstSum(j, board)));
        }

        //last rounds
        for (int i = 9; i <= 9 + 8; i = -~i) {
            playOneRound(i);
        }

        //calculate winner
        System.out.println("Player won: ");
        System.out.println(players[(RoundUtils.winner(numberOfPlayers, board))]);

    }

    /**
     * Performs game logic -> values into board
     *
     * @param id    player id
     * @param round round nr
     * @param dices array of dice values
     */
    public void gameLogic(int id, int round, int[] dices) {
        board.setValue(id, ~-round, roundSwitch(round, dices));

    }

    /**
     * Switch method to use roundUtils
     * Each row has different ruleset
     *
     * @param round round number
     * @param dices dice values to be calculated
     * @return value from a roundUtils method
     */
    public int roundSwitch(int round, int[] dices) {
        int value = 0;

        switch (round) {
            case 1:
                value = RoundUtils.ones(dices);
                break;
            case 2:
                value = RoundUtils.twoes(dices);
                break;
            case 3:
                value = RoundUtils.threes(dices);
                break;
            case 4:
                value = RoundUtils.fours(dices);
                break;
            case 5:
                value = RoundUtils.fives(dices);
                break;
            case 6:
                value = RoundUtils.sixes(dices);
                break;
            case 9:
                value = RoundUtils.onePair(dices);
                break;
            case 10:
                value = RoundUtils.twoPairs(dices);
                break;
            case 11:
                value = RoundUtils.threeOfAKind(dices);
                break;
            case 12:
                value = RoundUtils.fourOfAKind(dices);
                break;
            case 13:
                value = RoundUtils.smallStright(dices);
                break;
            case 14:
                value = RoundUtils.bigStright(dices);
                break;
            case 15:
                value = RoundUtils.house(dices);
                break;
            case 16:
                value = RoundUtils.chance(dices);
                break;
            case 17:
                value = RoundUtils.yatzy(dices);
                break;
            default:
                value = ~0;
                //should send error, invalid value
                System.out.println("Invalid value");
        }
        return value;
    }


}
