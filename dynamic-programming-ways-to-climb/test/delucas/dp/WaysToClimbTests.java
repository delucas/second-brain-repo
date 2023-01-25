package delucas.dp;

import org.junit.Assert;
import org.junit.Test;

public class WaysToClimbTests {

	final int n = 10;
	final int[] jumps = { 2, 4, 5, 8 };
	
	@Test
	public void recursive() {
		Assert.assertEquals(11, WaysToClimb.recursive(n, jumps));
	}

	@Test
	public void topDown() {
		Assert.assertEquals(11, WaysToClimb.topDown(n, jumps));
	}

	@Test
	public void bottomUp() {
		Assert.assertEquals(11, WaysToClimb.bottomUp(n, jumps));
	}

	// No se puede optimizar, ya que los anteriores necesarios
	// no son contiguos.

}
