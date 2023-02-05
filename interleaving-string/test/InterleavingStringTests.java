import org.junit.Assert;
import org.junit.Test;

import delucas.dp.InterleavingString;

public class InterleavingStringTests {

	String s1 = "aabcc";
	String s2 = "dbbca";
	String s3 = "aadbbcbcac";

	@Test
	public void recursive() {
		Assert.assertTrue(InterleavingString.recursive(s1, s2, s3));
	}
	
	@Test
	public void topDown() {
		Assert.assertTrue(InterleavingString.topDown(s1, s2, s3));
	}
	
	@Test
	public void bottomUp() {
		Assert.assertTrue(InterleavingString.bottomUp(s1, s2, s3));
	}

	@Test
	public void optimizedBottomUp() {
		Assert.assertTrue(InterleavingString.optimizedBottomUp(s1, s2, s3));
	}
}
