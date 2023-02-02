package delucas.dp;

import org.junit.Assert;
import org.junit.Test;

public class SquareMatrixOfOnesTests {

	int[][] matrix = {
            {0, 0, 1, 1, 1, 0},
            {1, 0, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 0, 1},
            {0, 1, 0, 1, 1, 1}
         };
	
	@Test
	public void recursive() {
		Assert.assertEquals(9, SquareMatrixOfOnes.recursive(matrix));
	}
	
	@Test
	public void topDown() {
		Assert.assertEquals(9, SquareMatrixOfOnes.topDown(matrix));
	}
	
	@Test
	public void bottomUp() {
		Assert.assertEquals(9, SquareMatrixOfOnes.bottomUp(matrix));
	}
	
	@Test
	public void bottomUp2() {
		Assert.assertEquals(9, SquareMatrixOfOnes.bottomUp2(matrix));
	}
	
	@Test
	public void optimizedBottomUp() {
		Assert.assertEquals(9, SquareMatrixOfOnes.optimizedBottomUp(matrix));
	}

}
