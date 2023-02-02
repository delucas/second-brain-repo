package delucas.dp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PathsInMatrixTests {

	int[][] matrix;

	@Before
	public void setup() {
		matrix = new int[][] {
          {0, 0, 1, 0, 1},
          {0, 0, 0, 0, 1},
          {0, 0, 1, 0, 0},
          {1, 0, 0, 0, 0}
		};
	}

	@Test
	public void test1() {
		Assert.assertEquals(7, RecursivePathsInMatrix.paths(matrix, 0, 0));
	}

	@Test
	public void test2() {
		Assert.assertEquals(7, TopDownPathsInMatrix.paths(matrix, 0, 0));
	}

	@Test
	public void test3() {
		Assert.assertEquals(7, BottomUpPathsInMatrix.paths(matrix, 0, 0));
	}

	@Test
	public void test4() {
		Assert.assertEquals(7, OptimizedBottomUpPathsInMatrix.paths(matrix, 0, 0));
	}
}
