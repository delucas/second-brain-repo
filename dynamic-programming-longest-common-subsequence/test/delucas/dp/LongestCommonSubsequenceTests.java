package delucas.dp;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubsequenceTests {

	final String s1 = "abdacbab";
	final String s2 = "acebfca";
	
	@Test
	public void recursive() {
		Assert.assertEquals(4, LongestCommonSubsequence.recursive(s1, s2, 0, 0));
	}
	
	@Test
	public void topDown() {
		Assert.assertEquals(4, LongestCommonSubsequence.topDown(s1, s2, 0, 0));
	}
	
	@Test
	public void bottomUp() {
		Assert.assertEquals(4, LongestCommonSubsequence.bottomUp(s1, s2, 0, 0));
	}
	
	@Test
	public void optimizedBottomUp() {
		Assert.assertEquals(4, LongestCommonSubsequence.optimizedBottomUp(s1, s2, 0, 0));
	}

}
