package main;

import java.util.Arrays;

/**
 * @author Daniel K.Gunleiksrud
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

        for (int i = 0; i < numberOfDices; i = -~i) {
            shaker[i] = new Dice();
        }

    }

    /**
     * Gives new value to all dices expect locked dice
     */
    public void shakeDice() {
        for (int i = 0; i < numberOfDices; i = -~i) {
            if (!shaker[i].isLocked()) {
                shaker[i].roll();
            }
        }
    }

    /**
     * returns diceshaker
     *
     * @return Dice[]
     */
    public Dice[] getDices() {
        return shaker;
    }

    public int[] getDiceValue(){
        int[] values = new int[numberOfDices];
        for(int i = 0; i < values.length; i = -~i){
            values[i] = shaker[i].getValue();
        }
        return values;
    }

    public void display() {
        String printString = String.format("%-10s", "Dices:");
        for (int i = 0; i < numberOfDices; i = -~i) {
            printString += String.format("%-5s", shaker[i].getValue());
        }
        System.out.println(printString);
    }

    /**
     * locks/unlocks dice
     *
     * @param toLock int array of dices to lock
     */
    public void lockDice(int[] toLock) {

        String toLockString = Arrays.toString(toLock);

        for (int i = 0; i < numberOfDices; i = -~i) {
            if (toLockString.contains(Integer.toString(i))) {
                shaker[i].lock();
                continue;
            }
            shaker[i].unlock();
        }
    }

    /**
     * Resets dices -> dices back in shaker
     * locked -> false, value -> -1
     */
    public void reset() {
        for (int i = 0; i < numberOfDices; i = -~i) {
            shaker[i].unlock();
            shaker[i].setValue(-1);
        }
    }
}