package tests;

import backend.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Daniel K.Gunleiksrud
 */

public class PlayerTest {


    @Test
    public void test() {

        String[] playerNames = {"Daniel", "Harald", "Per", "Petter"};
        Player[] players = new Player[4];
        for(int i = 0; i < players.length; i = -~i){
            players[i] = new Player(playerNames[i]);
        }

        assertEquals(players[0].getPlayerName(), playerNames[0]);
        assertEquals(players[1].getPlayerName(), playerNames[1]);
        assertEquals(players[2].getPlayerName(), playerNames[2]);
        assertEquals(players[3].getPlayerName(), playerNames[3]);

    }

}
