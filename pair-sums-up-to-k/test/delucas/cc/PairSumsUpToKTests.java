package delucas.cc;

import org.junit.Assert;
import org.junit.Test;

public class PairSumsUpToKTests {

	@Test
	public void canVerify() {
		int[] arr = { 4, 5, 1, 7, 6, 2 };
		int k = 10;
		Assert.assertTrue(PairSumsUpToK.solution1(arr, k));
		Assert.assertTrue(PairSumsUpToK.solution2(arr, k));
		Assert.assertTrue(PairSumsUpToK.solution3(arr, k));
	}
	
	@Test
	public void cannotVerify() {
		int[] arr = { 4, 5, 1, 7, 0, 2 };
		int k = 10;

		Assert.assertFalse(PairSumsUpToK.solution1(arr, k));
		Assert.assertFalse(PairSumsUpToK.solution2(arr, k));
		Assert.assertFalse(PairSumsUpToK.solution3(arr, k));
	}
}
