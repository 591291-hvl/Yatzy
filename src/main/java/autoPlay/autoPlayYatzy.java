package autoPlay;


import main.Board;
import main.DiceShaker;
import main.Player;
import main.RoundUtils;

import java.util.stream.Stream;

/**
 * @author Daniel K.Gunleiksrud
 * <p>
 * Autoplays game
 */

public class autoPlayYatzy {

    DiceShaker shaker;
    Player players;
    Board board;

    int numberOfDices;
    int numberOfPlayers;

    /**
     * Initializes classes to use in game
     *
     * @param numberOfDices   number of dices to play by
     * @param numberOfPlayers number of players:)
     */
    public autoPlayYatzy(int numberOfDices, int numberOfPlayers) {
        //create dice shaker, option to choose number of dices
        this.shaker = new DiceShaker(numberOfDices);
        this.numberOfDices = numberOfDices;
        this.numberOfPlayers = numberOfPlayers;

        //players
        //this.players = new Player(numberOfPlayers);
        String[] playerNames = {"Daniel", "Harald", "Per", "Petter"};
        this.players = new Player(playerNames);

        //board
        this.board = new Board(numberOfPlayers);


    }

    /**
     * prints how the board looks like in console
     */
    public void display() {
        String stringBoard = String.format("%-20s", "Players");
        ;
        String[] playerId = players.getPlayers();
        for (int i = 0; i < numberOfPlayers; i = -~i) {
            stringBoard += String.format("%-10s", playerId[i]);
        }
        stringBoard += "\n" + board.toString();

        System.out.println(stringBoard);
    }

    /**
     * Callable method to autoplayGame
     */
    public void playGame() {
        //rounds to play 6 + 9

        //first 6 rounds
        for (int i = 1; i <= 6; i = -~i) {
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
        System.out.println(players.getPlayer(RoundUtils.winner(numberOfPlayers, board)));

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
            display();
        }
    }

    /**
     * Plays round for one player
     *
     * @param id player id
     * @return int[] dice values
     */
    public int[] playPlayerRound(int id) {
        //Scanner sc = new Scanner(System.in);
        System.out.println("\n" + "Player " + players.getPlayer(id) + "'s turn");

        //roll happens 3 times, ability to keep 2 times


        for (int i = 0; i < 2; i = -~i) {
            //roll and display
            shaker.shakeDice();
            shaker.display();

            //option to keep
            //create int array from sc input
            //System.out.println("Write position of dice to keep 0-5, seperated by space");
            //int[] diceToLock = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).map(x -> ~-x).toArray();
            //lock dice
            //shaker.lockDice(diceToLock);
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
     * Performs game logic -> values into board
     *
     * @param id    player id
     * @param round round nr
     * @param dices array of dice values
     */
    public void gameLogic(int id, int round, int[] dices) {
        board.setValue(id, round - 1, roundSwitch(round, dices));

    }

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
                value = -1;
                //should send error, invalid value
                System.out.println("Invalid value");
        }
        return value;
    }

}
