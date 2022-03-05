package main;

import java.util.Random;

/**
 * @author Daniel K.Gunleiksrud
 *
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
	 * rolls a 6 sided dice
	 * @return int
	 */
	public int roll() {
		return random.nextInt(6)+1;
	}
	
	/**
	 * true if locked -> do not roll again
	 * false if not locked -> change value
	 * @return
	 */
	public boolean isLocked() {
		return locked;
	}
	
	

}
