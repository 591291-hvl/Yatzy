package tests;

import main.BitWise;
import main.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
	

	@Test
	public void test() {

		String[] playerName = {"User1", "User2", "User3", "User4"};

		Player players = new Player(playerName);

		assertEquals(players.getPlayer(0),playerName[0]);
		assertEquals(players.getPlayer(1),playerName[1]);
		assertEquals(players.getPlayer(2),playerName[2]);
		assertEquals(players.getPlayer(3),playerName[3]);

	}

}
