package tests;

import backend.Board;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Daniel K.Gunleiksrud
 */

public class BoardTest {


    @Test
    public void test() {
        Board board = new Board(4);

        assertEquals(board.getNumberOfPlayers(), 4);

        board.setValue(0, 0, 2);
        assertEquals(board.getBoard()[0][0], 2);


    }

    @Test
    public void printTest() {
        Board board = new Board(4);

        //idk if this is ok, but code coverage goes up ¯\_(ツ)_/¯
        assertEquals(board.toString()
                , "One's               -         -         -         -         \n" +
                "Two's               -         -         -         -         \n" +
                "Three's             -         -         -         -         \n" +
                "Four's              -         -         -         -         \n" +
                "Five's              -         -         -         -         \n" +
                "Six's               -         -         -         -         \n" +
                "Sum                 -         -         -         -         \n" +
                "Bonus               -         -         -         -         \n" +
                "One pair            -         -         -         -         \n" +
                "Two pair's          -         -         -         -         \n" +
                "Three of a kind     -         -         -         -         \n" +
                "Four of a kind      -         -         -         -         \n" +
                "Small straight      -         -         -         -         \n" +
                "Big straight        -         -         -         -         \n" +
                "Full house          -         -         -         -         \n" +
                "Chance              -         -         -         -         \n" +
                "YATZY               -         -         -         -         \n" +
                "Total Sum           -         -         -         -         \n");


        board.setValue(0,0,1);
        board.setValue(1,0,~0);

        assertEquals(board.toString()
                , "One's               1         0         -         -         \n" +
                        "Two's               -         -         -         -         \n" +
                        "Three's             -         -         -         -         \n" +
                        "Four's              -         -         -         -         \n" +
                        "Five's              -         -         -         -         \n" +
                        "Six's               -         -         -         -         \n" +
                        "Sum                 -         -         -         -         \n" +
                        "Bonus               -         -         -         -         \n" +
                        "One pair            -         -         -         -         \n" +
                        "Two pair's          -         -         -         -         \n" +
                        "Three of a kind     -         -         -         -         \n" +
                        "Four of a kind      -         -         -         -         \n" +
                        "Small straight      -         -         -         -         \n" +
                        "Big straight        -         -         -         -         \n" +
                        "Full house          -         -         -         -         \n" +
                        "Chance              -         -         -         -         \n" +
                        "YATZY               -         -         -         -         \n" +
                        "Total Sum           -         -         -         -         \n");

    }

}
