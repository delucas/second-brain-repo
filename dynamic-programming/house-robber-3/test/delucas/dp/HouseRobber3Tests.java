package delucas.dp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HouseRobber3Tests {

	@Test
	void example01() {
		int[] houses = { 3, 2, 3, -1, 3, -1, 1 };

		assertEquals(7, HouseRobber3.recursiva(houses));
		assertEquals(7, HouseRobber3.dinamica(houses));
	}

	@Test
	void example02() {
		int[] houses = { 3, 4, 5, 1, 3, -1, 1 };

		assertEquals(7, HouseRobber3.recursiva(houses));
		assertEquals(7, HouseRobber3.dinamica(houses));
	}

}
