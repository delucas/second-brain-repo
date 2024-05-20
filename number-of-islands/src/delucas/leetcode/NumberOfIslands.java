package delucas.leetcode;

public class NumberOfIslands {

	public static int solve(boolean[][] grid) {
		int islas = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j]) {
					inundar(grid, i, j);
					islas++;
				}
			}
		}
		return islas;
	}

	private static void inundar(boolean[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || !grid[i][j])
			return;
		
		grid[i][j] = false;
		inundar(grid, i-1, j);
		inundar(grid, i+1, j);
		inundar(grid, i, j-1);
		inundar(grid, i, j+1);
	}
}
