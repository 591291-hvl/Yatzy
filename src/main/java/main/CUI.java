package main;

import java.util.Scanner;

public class CUI {

    private static Yatzy yatzy;
    private static Scanner sc = new Scanner(System.in);


    public void createGame(){
        //in this version only 5 dices is allowed
        int numberOfDices = 5;
        //How many players
        System.out.println("How many players?");
        int numberOfPlayers = Integer.parseInt(sc.nextLine());
        yatzy = new Yatzy(numberOfDices, numberOfPlayers, setPlayers(numberOfPlayers));
    }


    /**
     * Uses scanner to write in names of players
     */
    public Player[] setPlayers(int numberOfPlayers) {

        Player[] players;

        players = new Player[numberOfPlayers];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < numberOfPlayers; i = -~i) {
            players[i] = new Player(sc.nextLine());
        }
        return players;
    }

    /**
     * prints how the board looks like in console
     */
    public void display() {
        System.out.println(yatzy.toString());
    }

}
