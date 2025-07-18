import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MostWaterTests {

	public int maxArea(int[] heights) {
		int maxArea = 0;

		int left = 0;
		int right = heights.length - 1;

		while (left < right) {
			int area = Math.min(heights[left], heights[right]) * (right - left);
			maxArea = Math.max(maxArea, area);

			// Muevo el que sea menor
			if (heights[left] < heights[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}

	@Test
	public void testExample1() {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int expected = 49;
		int result = maxArea(height);
		assertEquals(expected, result);
	}

	@Test
	public void testExample2() {
		int[] height = { 1, 1 };
		int expected = 1;
		int result = maxArea(height);
		assertEquals(expected, result);
	}

}
