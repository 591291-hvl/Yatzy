package tests;

import main.BitWise;
import main.Board;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {
	

	@Test
	public void test() {
		Board board = new Board(4);

		assertEquals(board.getNumberOfPlayers(), 4);

		board.setValue(0,0,2);
		assertEquals(board.getBoard()[0][0], 2);


	}

}
