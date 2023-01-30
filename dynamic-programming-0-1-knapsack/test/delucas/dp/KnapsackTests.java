package delucas.dp;

import org.junit.Assert;
import org.junit.Test;

public class KnapsackTests {

	int[] values = { 20, 30, 15, 25, 10 };
	int[] weights = { 6, 13, 5, 10, 3 };
	int k = 20;
	
	@Test
	public void recursive() {
		Assert.assertEquals(55, Knapsack.recursive(values, weights, k, 0));
	}

	@Test
	public void topDown() {
		Assert.assertEquals(55, Knapsack.topDown(values, weights, k, 0));
	}

	@Test
	public void bottomUp() {
		Assert.assertEquals(55, Knapsack.bottomUp(values, weights, k, 0));
	}
	
	@Test
	public void optimizedBottomUp() {
		Assert.assertEquals(55, Knapsack.optimizedBottomUp(values, weights, k, 0));
	}
}
