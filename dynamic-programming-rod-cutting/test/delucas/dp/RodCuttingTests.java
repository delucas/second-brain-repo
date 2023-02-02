package delucas.dp;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class RodCuttingTests {
	int[] prices = { 0, 1, 3, 5, 6, 7, 9, 10, 11 };
	
	@Test
	public void recursive() {
		Assert.assertEquals(13, RodCutting.recursive(prices));
	}
	
	@Test
	public void topDown() {
		Assert.assertEquals(13, RodCutting.topDown(prices));
	}

	@Test
	public void bottomUp() {
		Assert.assertEquals(13, RodCutting.bottomUp(prices));
	}
	
	// No se puede optimizar la forma bottom-up:
	// necesito todos los resultados previos.

}
