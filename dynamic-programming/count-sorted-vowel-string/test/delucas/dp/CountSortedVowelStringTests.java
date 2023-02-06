package delucas.dp;

import org.junit.Assert;
import org.junit.Test;

public class CountSortedVowelStringTests {

	@Test
	public void mathematical() {
		Assert.assertEquals(15, CountSortedVowelString.mathematical(2));
	}
	
	@Test
	public void recursive() {
		Assert.assertEquals(15, CountSortedVowelString.recursive(2));
	}
	
	@Test
	public void topDown() {
		Assert.assertEquals(15, CountSortedVowelString.topDown(2));
	}
	
	@Test
	public void bottomUp() {
		Assert.assertEquals(15, CountSortedVowelString.bottomUp(2));
	}
	
	@Test
	public void optimizedBottomUp() {
		Assert.assertEquals(15, CountSortedVowelString.optimizedBottomUp(2));
	}

}
