package main;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Yatzy {

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
    public Yatzy(int numberOfDices, int numberOfPlayers) {
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
     * Plays round for one player
     *
     * @param id player id
     * @return int[] dice values
     */
    public int[] playPlayerRound(int id) {
        Scanner sc = new Scanner(System.in);
        System.out.println( "\n" + "Player " + players.getPlayer(id) + "'s turn");

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
     */
    public void playOneRound() {

        for (int i = 0; i < numberOfPlayers; i = -~i) {
            //play round
            int[] diceValues = playPlayerRound(i);

            //logic method
            //needs id and round as parameter


            //display
            display();
        }
    }

    public void playGame() {
        //rounds to play 6 + 9
        for (int i = 0; i < 6; i = -~i) {
            playOneRound();
        }
    }


}
