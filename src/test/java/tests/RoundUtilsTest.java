package tests;

import backend.RoundUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Daniel K.Gunleiksrud
 */

public class RoundUtilsTest {


    @Test
    public void testones() {

        int[] dices = {1, 2, 3, 4, 5};
        assertEquals(RoundUtils.ones(dices), 1);
        assertNotEquals(RoundUtils.ones(dices), 0);
        assertNotEquals(RoundUtils.ones(dices), 2);
        dices[1] = 1;
        assertEquals(RoundUtils.ones(dices), 2);
        dices[2] = 1;
        dices[3] = 1;
        dices[4] = 1;
        assertEquals(RoundUtils.ones(dices), 5);
    }

    @Test
    public void testtwoes() {

        int[] dices = {1, 2, 3, 4, 5};
        assertEquals(RoundUtils.twoes(dices), 1 * 2);
        assertNotEquals(RoundUtils.twoes(dices), 0 * 2);
        assertNotEquals(RoundUtils.twoes(dices), 2 * 2);
        dices[0] = 2;
        assertEquals(RoundUtils.twoes(dices), 2 * 2);
        dices[2] = 2;
        dices[3] = 2;
        dices[4] = 2;
        assertEquals(RoundUtils.twoes(dices), 5 * 2);
    }

    @Test
    public void testRoundThree() {

        int[] dices = {1, 2, 3, 4, 5};
        assertEquals(RoundUtils.threes(dices), 1 * 3);
        assertNotEquals(RoundUtils.threes(dices), 0 * 3);
        assertNotEquals(RoundUtils.threes(dices), 2 * 3);
        dices[0] = 3;
        assertEquals(RoundUtils.threes(dices), 2 * 3);
        dices[1] = 3;
        dices[3] = 3;
        dices[4] = 3;
        assertEquals(RoundUtils.threes(dices), 5 * 3);
    }

    @Test
    public void testRoundFour() {

        int[] dices = {1, 2, 3, 4, 5};
        assertEquals(RoundUtils.fours(dices), 1 * 4);
        assertNotEquals(RoundUtils.fours(dices), 0 * 4);
        assertNotEquals(RoundUtils.fours(dices), 2 * 4);
        dices[0] = 4;
        assertEquals(RoundUtils.fours(dices), 2 * 4);
        dices[1] = 4;
        dices[2] = 4;
        dices[4] = 4;
        assertEquals(RoundUtils.fours(dices), 5 * 4);
    }

    @Test
    public void testRoundFive() {

        int[] dices = {1, 2, 3, 4, 5};
        assertEquals(RoundUtils.fives(dices), 1 * 5);
        assertNotEquals(RoundUtils.fives(dices), 0 * 5);
        assertNotEquals(RoundUtils.fives(dices), 2 * 5);
        dices[0] = 5;
        assertEquals(RoundUtils.fives(dices), 2 * 5);
        dices[1] = 5;
        dices[2] = 5;
        dices[3] = 5;
        assertEquals(RoundUtils.fives(dices), 5 * 5);
    }

    @Test
    public void testRoundSix() {

        int[] dices = {1, 2, 3, 4, 6};
        assertEquals(RoundUtils.sixes(dices), 1 * 6);
        assertNotEquals(RoundUtils.sixes(dices), 0 * 6);
        assertNotEquals(RoundUtils.sixes(dices), 2 * 6);
        dices[0] = 6;
        assertEquals(RoundUtils.sixes(dices), 2 * 6);
        dices[1] = 6;
        dices[2] = 6;
        dices[3] = 6;
        assertEquals(RoundUtils.sixes(dices), 5 * 6);
    }

    @Test
    public void testOnePair() {

        int[] dices = {1, 1, 3, 4, 4};
        assertEquals(RoundUtils.onePair(dices), 4 << 1);
        assertNotEquals(RoundUtils.onePair(dices), 1 << 1);
        dices[2] = 1;
        assertEquals(RoundUtils.onePair(dices), 4 << 1);
        assertNotEquals(RoundUtils.onePair(dices), 1 << 1);
        dices[2] = 4;
        assertEquals(RoundUtils.onePair(dices), 4 << 1);
        assertNotEquals(RoundUtils.onePair(dices), 1 << 1);

    }

    @Test
    public void testTwoPair() {

        int[] dices = {1, 1, 3, 4, 4};
        assertEquals(RoundUtils.twoPairs(dices), (4 << 1) + (1 << 1));
        dices[2] = 1;
        assertEquals(RoundUtils.twoPairs(dices), (4 << 1) + (1 << 1));
        dices[3] = 1;
        assertEquals(RoundUtils.twoPairs(dices), ~0);

    }

    @Test
    public void testThreeOfAKind() {

        int[] dices = {1, 1, 1, 4, 4};
        assertEquals(RoundUtils.threeOfAKind(dices), 1 * 3);
        dices[2] = 4;
        assertEquals(RoundUtils.threeOfAKind(dices), 4 * 3);
        dices[1] = 4;
        assertEquals(RoundUtils.threeOfAKind(dices), 4 * 3);
        dices[1] = 1;
        dices[2] = 3;
        assertEquals(RoundUtils.threeOfAKind(dices), ~0);


    }

    @Test
    public void testFourOfAKind() {

        int[] dices = {1, 1, 1, 4, 4};
        assertEquals(RoundUtils.fourOfAKind(dices), ~0);
        dices[3] = 1;
        assertEquals(RoundUtils.fourOfAKind(dices), 1 * 4);


    }

    @Test
    public void testSmallStraight() {

        int[] dices = {1, 2, 3, 4, 5};
        assertEquals(RoundUtils.smallStright(dices), ~-(2 << 3));
        dices[0] = 2;
        assertEquals(RoundUtils.smallStright(dices), ~0);


    }

    @Test
    public void testBigStraight() {

        int[] dices = {2, 3, 4, 5, 6};
        assertEquals(RoundUtils.bigStright(dices), 20);
        dices[4] = 2;
        assertEquals(RoundUtils.bigStright(dices), ~0);


    }

    @Test
    public void testHouse() {

        int[] dices = {2, 2, 4, 4, 4};
        assertEquals(RoundUtils.house(dices), (2 << 1) + 4 * 3);
        dices[2] = 2;
        assertEquals(RoundUtils.house(dices), (2 * 3) + (4 << 1));
        dices[2] = 1;
        assertEquals(RoundUtils.house(dices), ~0);

    }

    @Test
    public void testChance() {

        int[] dices = {1, 2, 3, 4, 5};
        assertEquals(RoundUtils.chance(dices), 1 + 2 + 3 + 4 + 5);
        dices[0] = 2;
        assertEquals(RoundUtils.chance(dices), 2 + 2 + 3 + 4 + 5);


    }

    @Test
    public void testYatzy() {

        int[] dices = {1, 1, 1, 1, 1};
        assertEquals(RoundUtils.yatzy(dices), 1 * 5);
        dices[0] = 2;
        dices[1] = 2;
        dices[2] = 2;
        dices[3] = 2;
        dices[4] = 2;
        assertEquals(RoundUtils.yatzy(dices), 2 * 5);
        dices[0] = 6;
        dices[1] = 6;
        dices[2] = 6;
        dices[3] = 6;
        dices[4] = 6;
        assertEquals(RoundUtils.yatzy(dices), 6 * 5);


    }
}
