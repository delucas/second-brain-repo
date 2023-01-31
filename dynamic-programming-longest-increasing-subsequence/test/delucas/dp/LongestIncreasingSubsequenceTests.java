package delucas.dp;

import org.junit.Assert;
import org.junit.Test;

public class LongestIncreasingSubsequenceTests {

	int[] arr = {7, 5, 2, 4, 7, 2, 3, 6, 4, 5, 12, 1, 7};
	
	@Test
	public void recursive() {
		Assert.assertEquals(5, LongestIncreasingSubsequence.recursive(arr));
	}
	
	@Test
	public void optimizedRecursive() {
		Assert.assertEquals(5, LongestIncreasingSubsequence.optimizedRecursive(arr));
	}
	
	@Test
	public void topDown() {
		Assert.assertEquals(5, LongestIncreasingSubsequence.topDown(arr));
	}

	@Test
	public void bottomUp() {
		Assert.assertEquals(5, LongestIncreasingSubsequence.bottomUp(arr));
	}
	
}
