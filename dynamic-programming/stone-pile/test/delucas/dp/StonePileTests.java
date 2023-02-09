package delucas.dp;

import org.junit.Assert;
import org.junit.Test;

public class StonePileTests {

	private int[] stones = { 5, 8, 13, 27, 14 };

	@Test
	public void recursive() {
		Assert.assertEquals(3, StonePile.recursive(stones));
	}
	
	@Test
	public void topDown() {
		Assert.assertEquals(3, StonePile.topDown(stones));
	}
	
	@Test
	public void bottomUp() {
		Assert.assertEquals(3, StonePile.bottomUp(stones));
	}
}
