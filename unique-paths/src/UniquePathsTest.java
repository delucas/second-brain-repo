import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UniquePathsTest {

	@Test
	void testUniquePathsCase1() {
		int m = 3;
		int n = 7;
		int expected = 28;
		assertEquals(expected, uniquePaths(m, n), "El número de rutas únicas para m = 3 y n = 7 debe ser 28");
	}

	@Test
	void testUniquePathsCase2() {
		int m = 3;
		int n = 2;
		int expected = 3;
		assertEquals(expected, uniquePaths(m, n), "El número de rutas únicas para m = 3 y n = 2 debe ser 3");
	}

	private int uniquePaths(int m, int n) {
		int[] dp = new int[n];

		for (int j = 0; j < n; j++) {
			dp[j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] += dp[j - 1];
			}
		}

		return dp[n - 1];
	}
}
