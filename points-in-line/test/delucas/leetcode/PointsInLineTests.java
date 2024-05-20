package delucas.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import delucas.utils.Pair;

class PointsInLineTests {

	@Test
	void example1() {
		Pair[] points = {
				new Pair(1,1),
				new Pair(2,2),
				new Pair(3,3)
		};
		
		assertEquals(3, PointsInLine.bruteForce(points));
		assertEquals(3, PointsInLine.quadratic(points));
	}
	
	@Test
	void example2() {
		Pair[] points = {
				new Pair(1,1),
				new Pair(3,2),
				new Pair(5,3),
				new Pair(4,1),
				new Pair(2,3),
				new Pair(1,4)
		};
		
		assertEquals(4, PointsInLine.bruteForce(points));
		assertEquals(4, PointsInLine.quadratic(points));
	}

}
