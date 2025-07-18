package delucas.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EqualSubstringsTest {

	@Test
	public void testExample1() {
		String s = "abcd";
		String t = "bcdf";
		int maxCost = 3;
		int expected = 3;
		assertEquals(expected, getMaxSubstringLength(s, t, maxCost));
	}

	@Test
	public void testExample2() {
		String s = "abcd";
		String t = "cdef";
		int maxCost = 3;
		int expected = 1;
		assertEquals(expected, getMaxSubstringLength(s, t, maxCost));
	}

	@Test
	public void testExample3() {
		String s = "abcd";
		String t = "acde";
		int maxCost = 0;
		int expected = 1;
		assertEquals(expected, getMaxSubstringLength(s, t, maxCost));
	}
	
	@Test
	public void testExample4() {
		String s = "abcd";
		String t = "zzzz";
		int maxCost = 10;
		int expected = 0;
		assertEquals(expected, getMaxSubstringLength(s, t, maxCost));
	}

	private int getMaxSubstringLength(String s, String t, int maxCost) {
		int n = s.length();
		int maxLength = 0;
		int currentCost = 0;
		int left = 0;

		for (int right = 0; right < n; right++) {
			currentCost += Math.abs(s.charAt(right) - t.charAt(right));

			while (currentCost > maxCost) {
				currentCost -= Math.abs(s.charAt(left) - t.charAt(left));
				left++;
			}

			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}

}
