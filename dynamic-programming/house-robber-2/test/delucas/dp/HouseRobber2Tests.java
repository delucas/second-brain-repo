package delucas.dp;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class HouseRobber2Tests {

	@Test
	public void example01() {
		int[] houses = {2,3,2};
		assertEquals(3, new HouseRobber2().recursive(houses));
	}
	
	@Test
	public void example02() {
		int[] houses = {1,2,3,1};
		assertEquals(4, new HouseRobber2().recursive(houses));
	}
	
	@Test
	public void example03() {
		int[] houses = {1,2,3};
		assertEquals(3, new HouseRobber2().recursive(houses));
	}
	
}
