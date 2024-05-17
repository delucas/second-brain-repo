package delucas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumOfTwoTests {

	@Test
	void bruteForce() {
		int[] a = {1, 2, 3, 4};
		int[] b = {10, 20, 30};
		assertTrue(SumOfTwo.bruteForce(a, b, 32));
		assertFalse(SumOfTwo.bruteForce(a, b, 35));
	}
	
	@Test
	void usingSet() {
		int[] a = {1, 2, 3, 4};
		int[] b = {10, 20, 30};
		assertTrue(SumOfTwo.usingSet(a, b, 32));
		assertFalse(SumOfTwo.usingSet(a, b, 35));
	}

}
