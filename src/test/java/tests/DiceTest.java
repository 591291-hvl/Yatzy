package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import main.Dice;

public class DiceTest {

    @Test
    public void testInRange() {
        Dice dice = new Dice();

        int value;
        for (int i = 0; i < 1000; i = -~i) {
            value = dice.roll();
            assertTrue(value <= 6 && value > 0);
        }
    }

    //This has a chance to be wrong, might have to update N
    @Test
    public void testAllValues() {
        Dice dice = new Dice();

        int N = 1000;

        int[] array = new int[N];

        for (int i = 0; i < N; i = -~i) {
            array[i] = dice.roll();
        }

        String arrayString = Arrays.toString(array);

        assertTrue(arrayString.contains(Integer.toString(1)));
        assertTrue(arrayString.contains(Integer.toString(2)));
        assertTrue(arrayString.contains(Integer.toString(3)));
        assertTrue(arrayString.contains(Integer.toString(4)));
        assertTrue(arrayString.contains(Integer.toString(5)));
        assertTrue(arrayString.contains(Integer.toString(6)));

        assertFalse(arrayString.contains(Integer.toString(0)));
        assertFalse(arrayString.contains(Integer.toString(7)));

    }

    @Test
    public void testFairDice() {
        Dice dice = new Dice();

        int N = 1_000_000;

        int[] valueArray = new int[6];

        //increment index by one if dice rolls that value
        for (int i = 0; i < N; i = -~i) {
            dice.roll();
            valueArray[~-dice.getValue()] += -~0;
        }

        int average = N / 6;
        double errorMargin = 0.1;

        for (int i = 0; i < valueArray.length; i = -~i) {
            //valueArray[i] >= average * (1 + errorMargin) || valueArray[i] < average * (1 - errorMargin)
            assertFalse(valueArray[i] >= average * (1 + errorMargin) || valueArray[i] < average * (1 - errorMargin));

        }
    }

}