package main;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Game logic for each round
 * Calculates value from dices
 */
public class RoundUtils {

    public int roundOne(int[] dices){
        return 1*(int) Stream.of(dices).filter(x -> x.equals(1)).count();
    }

    public int roundTwo(int[] dices){
        return 2*(int) Stream.of(dices).filter(x -> x.equals(2)).count();
    }

    public int roundThree(int[] dices){
        return 3*(int) Stream.of(dices).filter(x -> x.equals(3)).count();
    }

    public int roundFour(int[] dices){
        return 4*(int) Stream.of(dices).filter(x -> x.equals(4)).count();
    }

    public int roundFive(int[] dices){
        return 5*(int) Stream.of(dices).filter(x -> x.equals(5)).count();
    }

    public int roundSix(int[] dices){
        return 6*(int) Stream.of(dices).filter(x -> x.equals(6)).count();
    }

}
