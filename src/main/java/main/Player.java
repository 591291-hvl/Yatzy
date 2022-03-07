package main;

import java.util.Scanner;

/**
 * @author Daniel K.Gunleiksrud
 */

public class Player {

    //for now we can use id, but later we need
    String[] players;
    int numberOfPlayers;

    /**
     * constructor with scanner
     * player index is used for player id
     *
     * @param numberOfPlayers
     */
    public Player(int numberOfPlayers) {
        players = new String[numberOfPlayers];
        this.numberOfPlayers = numberOfPlayers;
        setPlayers();
    }

    /**
     * constructor with name array
     *
     * @param players string of player names
     */
    public Player(String[] players) {
        this.players = players;
        this.numberOfPlayers = players.length;
    }

    /**
     * Uses scanner to write in names of players
     */
    public void setPlayers() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < numberOfPlayers; i = -~i) {
            players[i] = sc.nextLine();
        }
    }


    /**
     * @return players
     */
    public String[] getPlayers() {
        return players;
    }

    /**
     * @param id of player
     * @return player name
     */
    public String getPlayer(int id) {
        return players[id];
    }
}
