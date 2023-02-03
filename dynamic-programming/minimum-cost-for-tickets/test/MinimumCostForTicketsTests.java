import org.junit.Assert;
import org.junit.Test;

import delucas.ap.MinimumCostForTickets;

public class MinimumCostForTicketsTests {

	Integer[] trainDays = { 1, 3, 8, 9, 22, 23, 28, 31 };
	int[] costs = { 4, 10, 25 };
	int n = 32;
	
	@Test
	public void recursive() {
		Assert.assertEquals(28, MinimumCostForTickets.recursive(trainDays, costs, n));
	}
	
	@Test
	public void topDown() {
		Assert.assertEquals(28, MinimumCostForTickets.topDown(trainDays, costs, n));
	}
	
	@Test
	public void bottomUp() {
		Assert.assertEquals(28, MinimumCostForTickets.bottomUp(trainDays, costs, n));
	}
	

}
