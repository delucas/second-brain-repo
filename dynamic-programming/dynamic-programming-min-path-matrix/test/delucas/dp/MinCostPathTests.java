package delucas.dp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinCostPathTests {

	int[][] matrix;

	@Before
	public void setup() {
		matrix = new int[][]{
				{ 3, 2, 12, 15, 10 },
				{ 6, 19, 7, 11, 17 },
				{ 8, 5, 12, 32, 21 },
				{ 3, 20, 2, 9, 7 }
		};
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(52, RecursiveMinCost.minCost(matrix, 0, 0));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(52, TopDownMinCost.minCost(matrix, 0, 0));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(52, BottomUpMinCost.minCost(matrix, 0, 0));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(52, OptimizedBottomUpMinCost.minCost(matrix, 0, 0));
	}
}
