package tests;

import main.RoundUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RoundUtilsTest {
	

	@Test
	public void testones() {

		int[] dices = {1,2,3,4,5};
		assertEquals(RoundUtils.ones(dices),1);
		assertNotEquals(RoundUtils.ones(dices),0);
		assertNotEquals(RoundUtils.ones(dices),2);
		dices[1] = 1;
		assertEquals(RoundUtils.ones(dices),2);
		dices[2] = 1;
		dices[3] = 1;
		dices[4] = 1;
		assertEquals(RoundUtils.ones(dices),5);
	}

	@Test
	public void testtwoes() {

		int[] dices = {1,2,3,4,5};
		assertEquals(RoundUtils.twoes(dices),1*2);
		assertNotEquals(RoundUtils.twoes(dices),0*2);
		assertNotEquals(RoundUtils.twoes(dices),2*2);
		dices[0] = 2;
		assertEquals(RoundUtils.twoes(dices),2*2);
		dices[2] = 2;
		dices[3] = 2;
		dices[4] = 2;
		assertEquals(RoundUtils.twoes(dices),5*2);
	}

	@Test
	public void testRoundThree() {

		int[] dices = {1,2,3,4,5};
		assertEquals(RoundUtils.threes(dices),1*3);
		assertNotEquals(RoundUtils.threes(dices),0*3);
		assertNotEquals(RoundUtils.threes(dices),2*3);
		dices[0] = 3;
		assertEquals(RoundUtils.threes(dices),2*3);
		dices[1] = 3;
		dices[3] = 3;
		dices[4] = 3;
		assertEquals(RoundUtils.threes(dices),5*3);
	}

	@Test
	public void testRoundFour() {

		int[] dices = {1,2,3,4,5};
		assertEquals(RoundUtils.fours(dices),1*4);
		assertNotEquals(RoundUtils.fours(dices),0*4);
		assertNotEquals(RoundUtils.fours(dices),2*4);
		dices[0] = 4;
		assertEquals(RoundUtils.fours(dices),2*4);
		dices[1] = 4;
		dices[2] = 4;
		dices[4] = 4;
		assertEquals(RoundUtils.fours(dices),5*4);
	}

	@Test
	public void testRoundFive() {

		int[] dices = {1,2,3,4,5};
		assertEquals(RoundUtils.fives(dices),1*5);
		assertNotEquals(RoundUtils.fives(dices),0*5);
		assertNotEquals(RoundUtils.fives(dices),2*5);
		dices[0] = 5;
		assertEquals(RoundUtils.fives(dices),2*5);
		dices[1] = 5;
		dices[2] = 5;
		dices[3] = 5;
		assertEquals(RoundUtils.fives(dices),5*5);
	}

	@Test
	public void testRoundSix() {

		int[] dices = {1,2,3,4,6};
		assertEquals(RoundUtils.sixes(dices),1*6);
		assertNotEquals(RoundUtils.sixes(dices),0*6);
		assertNotEquals(RoundUtils.sixes(dices),2*6);
		dices[0] = 6;
		assertEquals(RoundUtils.sixes(dices),2*6);
		dices[1] = 6;
		dices[2] = 6;
		dices[3] = 6;
		assertEquals(RoundUtils.sixes(dices),5*6);
	}



}
