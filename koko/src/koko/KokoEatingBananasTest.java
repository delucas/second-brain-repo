package koko;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class KokoEatingBananasTest {

	public int minEatingSpeed0(int[] piles, int h) {
		if (piles == null || piles.length == 0)
			return 0;
		if (h < piles.length)
			return -1;

		int max = Arrays.stream(piles).max().orElse(0);
		int minK = max;

		for (int k = 1; k <= max; k++) {
			int hours = 0;
			for (int pile : piles) {
				hours += (pile + k - 1) / k;
			}
			if (hours <= h) {
				minK = k;
				break;
			}
		}

		return minK;
	}

	public int minEatingSpeed(int[] piles, int h) {
		if (piles == null || piles.length == 0)
			return 0;
		if (h < piles.length)
			return -1;

		int max = Arrays.stream(piles).max().orElse(0);
		int left = 1, right = max;
		int result = max;

		while (left <= right) {
			int k = left + (right - left) / 2;
			int hours = 0;
			for (int pile : piles) {
				hours += (pile + k - 1) / k;
			}
			if (hours <= h) {
				result = k;
				right = k - 1;
			} else {
				left = k + 1;
			}
		}

		return result;
	}

	@Test
	public void testExample1() {
		int[] piles = { 3, 6, 7, 11 };
		int h = 8;
		assertEquals(4, minEatingSpeed(piles, h));
	}

	@Test
	public void testExample2() {
		int[] piles = { 30, 11, 23, 4, 20 };
		int h = 5;
		assertEquals(30, minEatingSpeed(piles, h));
	}

	@Test
	public void testExample3() {
		int[] piles = { 30, 11, 23, 4, 20 };
		int h = 6;
		assertEquals(23, minEatingSpeed(piles, h));
	}

	// Puedes agregar más casos de prueba según sea necesario
}