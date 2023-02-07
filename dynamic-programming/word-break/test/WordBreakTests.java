import org.junit.Assert;
import org.junit.Test;

import delucas.dp.WordBreak;

public class WordBreakTests {

	String s = "catsandogsareanimals";
	String[] words = { "cats", "dog", "sand", "and", "cat", "mals", "san", "dogs", "are", "animal", "ani", "og",
			"sar" };

	@Test
	public void recursive() {
		Assert.assertTrue(WordBreak.recursive(s, words));
	}
	
	@Test
	public void topDown() {
		Assert.assertTrue(WordBreak.topDown(s, words));
	}
	
	@Test
	public void bottomUp() {
		Assert.assertTrue(WordBreak.bottomUp(s, words));
	}

}
