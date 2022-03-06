package main;

public class Player {

    //for now we can use id, but later we need
    int[] players;
    int numberOfPlayers;

    /**
     * player index is used for player id
     *
     * @param numberOfPlayers
     */
    public Player(int numberOfPlayers) {
        players = new int[numberOfPlayers];
        this.numberOfPlayers = numberOfPlayers;
    }

    /**
     *
     * @return players
     */
    public int[] getPlayers() {
        return players;
    }
}
