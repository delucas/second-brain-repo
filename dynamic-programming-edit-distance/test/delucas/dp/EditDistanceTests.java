package delucas.dp;

import org.junit.Assert;
import org.junit.Test;

public class EditDistanceTests {
	
	String word1 = "inside";
	String word2 = "index";
	
	
	@Test
	public void recursive() {
		Assert.assertEquals(3, EditDistance.recursive(word1, word2, 0, 0));
	}

	@Test
	public void topDown() {
		Assert.assertEquals(3, EditDistance.topDown(word1, word2, 0, 0));
	}

	@Test
	public void bottomUp() {
		Assert.assertEquals(3, EditDistance.bottomUp(word1, word2, 0, 0));
	}

	@Test
	public void optimizedBottomUp() {
		Assert.assertEquals(3, EditDistance.optimizedBottomUp(word1, word2, 0, 0));
	}

}
