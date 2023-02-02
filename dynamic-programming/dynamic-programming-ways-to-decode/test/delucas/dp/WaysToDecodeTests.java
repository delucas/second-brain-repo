package delucas.dp;

import org.junit.Assert;
import org.junit.Test;

public class WaysToDecodeTests {

	String s = "512810120129";
	
	@Test
	public void recursive() {
		Assert.assertEquals(4, WaysToDecode.recursive(s));
	}
	
	@Test
	public void topDown() {
		Assert.assertEquals(4, WaysToDecode.topDown(s));
	}

	@Test
	public void bottomUp() {
		Assert.assertEquals(4, WaysToDecode.bottomUp(s));
	}
	
	@Test
	public void optimizedBottomUp() {
		Assert.assertEquals(4, WaysToDecode.optimizedBottomUp(s));
	}
}
