package delucas.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberOfIslandsTests {

	private boolean x = true;
	private boolean o = false;
	
	@Test
	void ejemplo1() {
		boolean[][] grid = {
		    	{x,x,x,x,o},
		    	{x,x,o,x,o},
		    	{x,x,o,o,o},
		    	{o,o,o,o,o}
		    };
		   assertEquals(1, NumberOfIslands.solve(grid));
	}
	
	@Test
	void ejemplo2() {
		boolean[][] grid = {
		    	{x,x,o,o,o},
		    	{x,x,o,o,o},
		    	{o,o,x,o,o},
		    	{o,o,o,x,x}
		    };
		   assertEquals(3, NumberOfIslands.solve(grid));
	}
}
