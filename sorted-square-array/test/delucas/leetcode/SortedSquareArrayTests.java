package delucas.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortedSquareArrayTests {

	@Test
	void exampleOne() {
		int[] input = {-4,-1,0,3,10};
		int[] expected = {0,1,9,16,100};
		
		assertArrayEquals(expected, SortedSquareArray.naive(input));
		assertArrayEquals(expected, SortedSquareArray.withMemory(input));
		assertArrayEquals(expected, SortedSquareArray.outsideIn(input));
	}
	
	@Test
	void exampleTwo() {
		int[] input = {-7,-3,2,3,11};
		int[] expected = {4,9,9,49,121};
		
		assertArrayEquals(expected, SortedSquareArray.naive(input));
		assertArrayEquals(expected, SortedSquareArray.withMemory(input));
		assertArrayEquals(expected, SortedSquareArray.outsideIn(input));
	}

}
