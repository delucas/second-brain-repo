package delucas.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CandyDistributionTest {

	@Test
	public void testExample1() {
		int[] ratings = { 1, 0, 2 };
		int expected = 5;
		int result = minimumCandies(ratings);
		assertEquals(expected, result);
	}

	@Test
	public void testExample2() {
		int[] ratings = { 1, 2, 2 };
		int expected = 4;
		int result = minimumCandies(ratings);
		assertEquals(expected, result);
	}

	@Test
	public void testExample3() {
		int[] ratings = { 5, 4, 3, 5, 6, 2 };
		int expected = 12;
		int result = minimumCandies(ratings);
		assertEquals(expected, result);
	}

	private int minimumCandies(int[] ratings) {
		int[] candies = new int[ratings.length];

		candies[0] = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				candies[i] = 1;
			}
		}

		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}
		}

		//  Totalize. Can be merged with previous cycle
		int totalCandies = 0;
		for (int i = 0; i < candies.length; i++) {
			totalCandies += candies[i];
		}

		return totalCandies;
	}
}
