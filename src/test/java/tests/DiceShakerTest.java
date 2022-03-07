package tests;

import main.Dice;
import main.DiceShaker;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * @author Daniel K.Gunleiksrud
 */

public class DiceShakerTest {

    @Test
    public void testShaker() {

        DiceShaker shaker = new DiceShaker(5);

        Dice[] dices = shaker.getDices();

        assertEquals(dices[0].getValue(), -1);
        assertEquals(dices[1].getValue(), -1);
        assertEquals(dices[2].getValue(), -1);
        assertEquals(dices[3].getValue(), -1);
        assertEquals(dices[4].getValue(), -1);

        shaker.shakeDice();

        assertNotEquals(dices[0].getValue(), -1);
        assertNotEquals(dices[1].getValue(), -1);
        assertNotEquals(dices[2].getValue(), -1);
        assertNotEquals(dices[3].getValue(), -1);
        assertNotEquals(dices[4].getValue(), -1);

    }

    @Test
    public void testLocked() {

        DiceShaker shaker = new DiceShaker(5);
        Dice[] dices = shaker.getDices();

        shaker.shakeDice();

        int value1 = dices[0].getValue();
        int[] toLock = {0};
        shaker.lockDice(toLock);

        //Loop to really really make sure its the same value
        for (int i = 0; i < 100; i = -~i) {
            shaker.shakeDice();
            assertEquals(dices[0].getValue(), value1);
        }

        shaker.lockDice(new int[0]);

        //Loop to really really make sure its the same value
        boolean changed = false;
        for (int i = 0; i < 100; i = -~i) {
            shaker.shakeDice();
            if (dices[0].getValue() != value1) {
                changed = true;
                break;
            }
        }
        assertTrue(changed);


    }


}
