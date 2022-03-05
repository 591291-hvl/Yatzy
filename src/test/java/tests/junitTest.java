package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import main.BitWise;

public class junitTest {
	
	BitWise bitWise = new BitWise();

	@Test
	public void test() {
		assertEquals(10, bitWise.increment(9));
	}

}
