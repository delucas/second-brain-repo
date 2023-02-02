package delucas.dp;

import org.junit.Assert;
import org.junit.Test;

public class CoinChangeTests {

	final int amount = 15;
	final int[] coins = { 2, 3, 7 };

	@Test
	public void recursive() {
		Assert.assertEquals(4, CoinChange.recursive(amount, coins));
	}

	@Test
	public void topDown() {
		Assert.assertEquals(4, CoinChange.topDown(amount, coins));
	}

	@Test
	public void bottomUp() {
		Assert.assertEquals(4, CoinChange.bottomUp(amount, coins));
	}

	// No se puede optimizar, ya que los anteriores necesarios
	// no son contiguos.

}
