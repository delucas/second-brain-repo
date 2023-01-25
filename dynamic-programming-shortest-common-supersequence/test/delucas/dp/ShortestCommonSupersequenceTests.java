package delucas.dp;

import org.junit.Assert;
import org.junit.Test;

public class ShortestCommonSupersequenceTests {

	final String s1 = "abdacbab";
	final String s2 = "acebfca";

	@Test
	public void reutilizesLCS() {
		Assert.assertEquals(11, ShortestCommonSupersequence.reutilize(s1, s2, 0, 0));
	}
	
	@Test
	public void recursive() {
		Assert.assertEquals(11, ShortestCommonSupersequence.recursive(s1, s2, 0, 0));
	}
	
	@Test
	public void topDown() {
		Assert.assertEquals(11, ShortestCommonSupersequence.topDown(s1, s2, 0, 0));
	}
	
	@Test
	public void bottomUp() {
		Assert.assertEquals(11, ShortestCommonSupersequence.bottomUp(s1, s2, 0, 0));
	}
	
	@Test
	public void optimizedBottomUp() {
		Assert.assertEquals(11, ShortestCommonSupersequence.optimizedBottomUp(s1, s2, 0, 0));
	}
}
