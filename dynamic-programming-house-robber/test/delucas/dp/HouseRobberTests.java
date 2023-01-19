package delucas.dp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseRobberTests {

	int[] houses;

	@Before
	public void setup() {
		houses = new int[] { 2, 10, 3, 6, 8, 1, 7 };
	}

	@Test
	public void test1() {
		Assert.assertEquals(25, RecursiveHouseRobber.rob(houses, 0));
	}

	@Test
	public void test2() {
		Assert.assertEquals(25, TopDownHouseRobber.rob(houses, 0));
	}

	@Test
	public void test3() {
		Assert.assertEquals(25, BottomUpHouseRobber.rob(houses, 0));
	}

	@Test
	public void test4() {
		Assert.assertEquals(25, OptimizedBottomUpHouseRobber.rob(houses, 0));
	}

}
