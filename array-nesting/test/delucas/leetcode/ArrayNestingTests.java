package delucas.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArrayNestingTests {

	@Test
	public void exampleBruteForce() {
		int[] input = { 5, 4, 0, 3, 1, 6, 2 };
		assertEquals(4, ArrayNesting.bruteForce(input));
	}
	
	@Test
	public void exampleMemoized() {
		int[] input = { 5, 4, 0, 3, 1, 6, 2 };
		assertEquals(4, ArrayNesting.memoized(input));
	}
	
	@Test
	public void exampleDiscardingElements() {
		int[] input = { 5, 4, 0, 3, 1, 6, 2 };
		assertEquals(4, ArrayNesting.discardingElements(input));
	}

}
