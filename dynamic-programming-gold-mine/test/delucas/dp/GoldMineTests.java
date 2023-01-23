package delucas.dp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoldMineTests {

	int[][] mine;
	
	@Before
	public void setup() {
		mine = new int[][] {
			{ 3,  2, 12, 15, 10 },
			{ 6, 19,  7, 11, 17 },
			{ 8,  5, 12, 32, 21 },
			{ 3, 20,  2,  9,  7 } };
	}
	
	@Test
	public void recursive() {
		Assert.assertEquals(73, GoldMine.recursive(mine));
	}
	
	@Test
	public void topDown() {
		Assert.assertEquals(73, GoldMine.topDown(mine));
	}
	
	@Test
	public void bottomUp() {
		Assert.assertEquals(73, GoldMine.bottomUp(mine));
	}
	
	@Test
	public void optimizedBottomUp() {
		Assert.assertEquals(73, GoldMine.optimizedBottomUp(mine));
	}

}
