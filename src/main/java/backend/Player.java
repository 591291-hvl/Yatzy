package backend;

/**
 * @author Daniel K.Gunleiksrud
 */

public class Player {

    //for now we can use id, but later we need
    private String playerName;


    /**
     *
     * @param playerName string of player name
     */
    public Player(String playerName) {
        this.playerName = playerName;
    }


    /**
     * @return players
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     *
     * @param playerName
     */
    public void SetName(String playerName){
        this.playerName = playerName;
    }

}
