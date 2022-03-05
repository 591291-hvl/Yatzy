package main;

import java.util.Arrays;

/**
 * @author Daniel K.Gunleiksrud
 *
 */
public class DiceShaker {
	
	Dice[] shaker;
	int numberOfDices;
	
	/**
	 * Container for multiple dices
	 * Creates terning in kopp
	 */
	public DiceShaker(int numberOfDices) {
		this.shaker = new Dice[numberOfDices];
		this.numberOfDices = numberOfDices;
		
		for(int i = 0; i < numberOfDices; i = -~i) {
			shaker[i] = new Dice();
		}
		
	}
	
	/**
	 * Gives new value to all dices expect locked dice
	 */
	public void shakeDice() {
		for(int i = 0; i < numberOfDices; i = -~i) {
			if(!shaker[i].isLocked()) {
				shaker[i].roll();
			}
		}
	}
	
	/**
	 * returns diceshaker
	 * @return Dice[]
	 */
	public Dice[] getDices() {
		return shaker;
	}
	
	/**
	 * locks/unlocks dice
	 * @param int array of dices to lock
	 */
	public void lockDice(int[] toLock) {
		
		String toLockString = Arrays.toString(toLock);
		
		for(int i = 0; i < numberOfDices; i = -~i) {
			if(toLockString.contains(Integer.toString(i))) {
//				shaker[i]
			}
		}
	}
	
	

}
