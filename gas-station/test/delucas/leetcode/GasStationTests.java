package delucas.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class GasStationTests {

	GasStation g = new GasStation();

	@Test
	public void example1() {
		int[] gas = { 1, 2, 3, 4, 5 }, cost = { 3, 4, 5, 1, 2 };
		Assert.assertEquals(3, g.canCompleteCircuit(gas, cost));
	}

	@Test
	public void example2() {
		int[] gas = { 2, 3, 4 }, cost = { 3, 4, 3 };
		Assert.assertEquals(-1, g.canCompleteCircuit(gas, cost));
	}

	@Test
	public void caseWhenNeedsToBreak() {
		int[] gas = { 5, 1, 2, 3, 4 }, cost = { 4, 4, 1, 5, 1 };
		Assert.assertEquals(4, g.canCompleteCircuit(gas, cost));
	}
	
	@Test
	public void load() {
		int[] gas = new int[100000];
		gas[99999] = 2;
		int[] cost = new int[100000];
		cost[99998] = 1;
		Assert.assertEquals(99999, g.canCompleteCircuit(gas, cost));
	}

}
