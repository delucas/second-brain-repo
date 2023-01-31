package delucas.dp;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SubsetSumTests {

	int[] arr = { 1, 2, 3, 1 };
	int k = 4;
	
	@Test
	public void recursive() {
		Assert.assertEquals(3, SubsetSum.recursive(arr, k, 0));
	}

	@Test
	public void topDown() {
		Assert.assertEquals(3, SubsetSum.topDown(arr, k, 0));
	}

	@Test
	public void bottomUp() {
		Assert.assertEquals(3, SubsetSum.bottomUp(arr, k, 0));
	}
	
	@Test
	public void optimizedBottomUp() {
		Assert.assertEquals(3, SubsetSum.optimizedBottomUp(arr, k, 0));
	}

}
