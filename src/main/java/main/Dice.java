package main;

import java.util.Random;

/**
 * @author Daniel K.Gunleiksrud
 */
public class Dice {

    private Random random = new Random();

    private int value;
    private boolean locked;

    /**
     * value is -1 if not rolled, not used
     * dice has no initial value, have to be rolled
     */
    public Dice() {
        this.value = -1;
        this.locked = false;
    }

    /**
     * Gets current dice value
     *
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * Manual way to change dice, should not be used in game
     *
     * @param newValue new value for dice
     */
    public void setValue(int newValue) {
        this.value = newValue;
    }

    /**
     * rolls a 6 sided dice
     *
     * @return int
     */
    public int roll() {
        this.value = random.nextInt(6) + 1;
        return value;
    }

    /**
     * true if locked -> do not roll again
     * false if not locked -> change value
     *
     * @return
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * locks dice
     */
    public void lock() {
        this.locked = true;
    }

    /**
     * unlocks dice
     */
    public void unlock() {
        this.locked = false;
    }

}
