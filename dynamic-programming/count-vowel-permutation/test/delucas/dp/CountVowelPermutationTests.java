package delucas.dp;

import org.junit.Assert;
import org.junit.Test;

public class CountVowelPermutationTests {

	int[] inputs = {1,2,5};
	int[] expecteds = {5,10,68};
	
	@Test
	public void recursive() {
		for (int i = 0; i < expecteds.length; i++) {	
			Assert.assertEquals(expecteds[i], CountVowelPermutation.recursive(inputs[i]));
		}
	}
	
	@Test
	public void topDown() {
		for (int i = 0; i < expecteds.length; i++) {	
			Assert.assertEquals(expecteds[i], CountVowelPermutation.topDown(inputs[i]));
		}
	}
	
	@Test
	public void bottomUp() {
		for (int i = 0; i < expecteds.length; i++) {	
			Assert.assertEquals(expecteds[i], CountVowelPermutation.bottomUp(inputs[i]));
		}
	}
	
	@Test
	public void optimizedBottomUp() {
		for (int i = 0; i < expecteds.length; i++) {	
			Assert.assertEquals(expecteds[i], CountVowelPermutation.optimizedBottomUp(inputs[i]));
		}
		Assert.assertEquals(18208803, CountVowelPermutation.optimizedBottomUp(144));
	}
	
	@Test
	public void superOptimizedBottomUp() {
		for (int i = 0; i < expecteds.length; i++) {	
			Assert.assertEquals(expecteds[i], CountVowelPermutation.superOptimizedBottomUp(inputs[i]));
		}
		Assert.assertEquals(18208803, CountVowelPermutation.superOptimizedBottomUp(144));
	}
}
