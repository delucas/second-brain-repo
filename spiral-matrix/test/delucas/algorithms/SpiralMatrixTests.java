package delucas.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpiralMatrixTests {

	@Test
	void test() {
		int[][] matrix = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
		Integer[] expected = {1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10};
		
		Integer[] out = SpiralMatrix.traverse(matrix);
		assertArrayEquals(expected, out);
	}

}
