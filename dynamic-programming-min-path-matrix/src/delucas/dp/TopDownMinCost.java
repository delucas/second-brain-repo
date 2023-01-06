package delucas.dp;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TopDownMinCost {
	public static int minCost(final int[][] matrix, final int i, final int j) {
		return minCost(matrix, i, j, new HashMap<Pair, Integer>());
	}
	
	public static int minCost(final int[][] matrix, final int i, final int j, Map<Pair, Integer> mem) {
		Pair currentKey = new Pair(i, j);

		if (mem.containsKey(currentKey)) {
			return mem.get(currentKey);
		}

		int n = matrix.length;
		int m = matrix[0].length;

		if (i == n - 1 && j == m - 1) {
			mem.put(currentKey, matrix[i][j]);
		} else if (i == n - 1) {
			mem.put(currentKey, matrix[i][j] + minCost(matrix, i, j + 1, mem));
		} else if (j == m - 1) {
			mem.put(currentKey, matrix[i][j] + minCost(matrix, i + 1, j, mem));
		} else {
			mem.put(currentKey, matrix[i][j] +
					Math.min(minCost(matrix, i + 1, j, mem), minCost(matrix, i, j + 1, mem)));
		}
		return mem.get(currentKey);
	}
}

class Pair {
	int x, y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		return x == other.x && y == other.y;
	}
}
