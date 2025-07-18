package pruls;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

class PrulsTests {

	class Pruls {
		int maxProfit = 0;
		Integer[] buy;

		public Pruls(int maxProfit, Integer[] buy) {
			super();
			this.maxProfit = maxProfit;
			this.buy = Arrays.copyOf(buy, Math.min(10, buy.length));
		}

	}

	@Test
	void test() {
		int[][] workyards = { { 7, 3, 11, 9, 10 }, { 100, 100, 100 }, { 1, 2, 3, 4, 10, 16, 10, 4, 16 } };

		Pruls result = process(workyards);

		assertEquals(40, result.maxProfit);
		assertArrayEquals(new Integer[] { 6, 7, 8, 9, 10, 12, 13 }, result.buy);
	}

	private Pruls process(int[][] workyards) {
		int grandMax = 0;
		ArrayList<ArrayList<Integer>> grandNums = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < workyards.length; i++) {
			int max = Integer.MIN_VALUE;
			ArrayList<Integer> nums = new ArrayList<Integer>();
			max = processWorkyard(workyards[i], max, nums);

			if (max > 0) {
				grandMax += max;
				grandNums.add(nums);
			}
		}

        Integer[][] prulsToBuy = grandNums.stream()
                .map(l -> l.toArray(new Integer[0]))
                .toArray(Integer[][]::new);
		
		Integer[] buyablePruls = calculateAllPossiblePrulsToBuy(prulsToBuy);

		return new Pruls(grandMax, buyablePruls);
	}

	private int processWorkyard(int[] workyard, int max, ArrayList<Integer> nums) {
		int dp = 0; // no comprar ningún Prul
		
		for (int i = 0; i < workyard.length; i++) {
			dp += 10 - workyard[i];
			if (dp == max) {
				nums.add(i + 1);
			} else if (dp > max) {
				max = dp;
				nums.clear();
				nums.add(i + 1);
			}
		}
		return max;
	}

	private Integer[] calculateAllPossiblePrulsToBuy(Integer[][] prulsToBuy) {
		TreeSet<Integer> result = new TreeSet<Integer>();
		calculate(prulsToBuy, 0, 0, result);

		return result.toArray(new Integer[0]);
	}

	private void calculate(Integer[][] prulsToBuy, int idx, int partialSum, TreeSet<Integer> result) {
		if (idx == prulsToBuy.length) {
			if (partialSum > 0) {
				result.add(partialSum);
			}
			return;
		}
		for (int i = 0; i < prulsToBuy[idx].length; i++) {
			calculate(prulsToBuy, idx + 1, partialSum + prulsToBuy[idx][i], result);
		}
	}
}
