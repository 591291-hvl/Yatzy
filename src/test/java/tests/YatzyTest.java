package tests;

import backend.Player;
import backend.Yatzy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class YatzyTest {


	@Test
	public void switchTest() {

		String[] playerNames = {"Daniel", "Harald", "Per", "Petter"};
		Player[] players = new Player[4];
		for(int i = 0; i < players.length; i = -~i){
			players[i] = new Player(playerNames[i]);
		}

		Yatzy yatzy = new Yatzy(5, 4, players);
		int[] dices = {1,1,2,2,3};


		assertEquals(yatzy.roundSwitch(1,dices),2);
		assertEquals(yatzy.roundSwitch(2,dices),4);
		assertEquals(yatzy.roundSwitch(3,dices),3);
		dices[3] = 4;
		assertEquals(yatzy.roundSwitch(4,dices),4);
		dices[4] = 5;
		assertEquals(yatzy.roundSwitch(5,dices),5);

		assertEquals(yatzy.roundSwitch(6,dices),~0);


		assertEquals(yatzy.roundSwitch(9,dices),2);
		dices[3] = 2;
		assertEquals(yatzy.roundSwitch(10,dices),2+4);
		dices[1] = 2;
		assertEquals(yatzy.roundSwitch(11,dices),2*3);
		dices[0] = 2;
		assertEquals(yatzy.roundSwitch(12,dices),2*4);

		dices[0] = 1;
		dices[1] = 2;
		dices[2] = 3;
		dices[3] = 4;
		dices[4] = 5;
		assertEquals(yatzy.roundSwitch(13,dices),15);
		dices[0] = 2;
		dices[1] = 3;
		dices[2] = 4;
		dices[3] = 5;
		dices[4] = 6;
		assertEquals(yatzy.roundSwitch(14,dices),20);
		dices[0] = 2;
		dices[1] = 2;
		dices[2] = 4;
		dices[3] = 4;
		dices[4] = 4;

		assertEquals(yatzy.roundSwitch(15,dices),2*2 +4*3);
		dices[0] = 2;
		dices[1] = 4;
		dices[2] = 4;
		dices[3] = 4;
		dices[4] = 4;

		assertEquals(yatzy.roundSwitch(16,dices),2+4*4);
		dices[0] = 4;
		assertEquals(yatzy.roundSwitch(17,dices),4*5);

		assertEquals(yatzy.roundSwitch(18,dices),~0);
		assertEquals(yatzy.roundSwitch(0,dices),~0);







	}

}
