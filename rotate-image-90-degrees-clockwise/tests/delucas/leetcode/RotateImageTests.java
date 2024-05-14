package delucas.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RotateImageTests {

	@Test
	void simpleTest() {
		int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		int[][] expected = new int[][]{{7,4,1},{8,5,2},{9,6,3}};
		
		RotateImage.rotate90clockwise(matrix);
		
		assertArrayEquals(expected, matrix);
	}
	
	@Test
	void simpleTestAlt() {
		int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		int[][] expected = new int[][]{{7,4,1},{8,5,2},{9,6,3}};
		
		RotateImage.rotate90clockwiseAlt(matrix);
		
		assertArrayEquals(expected, matrix);
	}
	
	@Test
	void biggerTest() {
		int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] expected = new int[][]{{13,9,5,1},{14,10,6,2},{15,11,7,3},{16,12,8,4}};
		
		RotateImage.rotate90clockwise(matrix);
		
		assertArrayEquals(expected, matrix);
	}
	
	@Test
	void biggerTestAlt() {
		int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] expected = new int[][]{{13,9,5,1},{14,10,6,2},{15,11,7,3},{16,12,8,4}};
		
		RotateImage.rotate90clockwiseAlt(matrix);
		
		assertArrayEquals(expected, matrix);
	}
	
	@Test
	void anotherTest() {
		int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		int[][] expected = new int[][]{{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}};
		
		RotateImage.rotate90clockwise(matrix);
		
		assertArrayEquals(expected, matrix);
	}
	
	@Test
	void anotherTestAlt() {
		int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		int[][] expected = new int[][]{{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}};
		
		RotateImage.rotate90clockwiseAlt(matrix);
		
		assertArrayEquals(expected, matrix);
	}

}
