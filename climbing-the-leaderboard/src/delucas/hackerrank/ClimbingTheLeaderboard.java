package delucas.hackerrank;

public class ClimbingTheLeaderboard {
	public static int[] solve(int[] ranking, int[] player) {
		int total = 1;
		for (int i = 1; i < ranking.length; i++) {
			if (ranking[i] != ranking[i-1])
				total++;
		}
		
		int[] rank = new int[total];
		rank[0] = ranking[0];
		
		for (int i = 1, j = 1; i < ranking.length; i++) {
			if (ranking[i] != ranking[i-1]) {
				rank[j++] = ranking[i];
			}
		}
		
		int[] res = new int[player.length];
		int r = 0;
		
		for (int i = 0; i < player.length; i++) {
			int score = player[i];
			boolean found = false;
			for (int j = 0; j < rank.length; j++) {
				if (score >= rank[j]) {
					res[r++] = j+1;
					found = true;
					break;
				}
			}
			if (!found) {
				res[r++] = total+1;
			}
			
		}
		return res;
	}
	
	public static int[] solveOptimized(int[] ranking, int[] player) {
		int total = 1;
		for (int i = 1; i < ranking.length; i++) {
			if (ranking[i] != ranking[i-1])
				total++;
		}
		
		int[] rank = new int[total];
		rank[0] = ranking[0];
		
		for (int i = 1, j = 1; i < ranking.length; i++) {
			if (ranking[i] != ranking[i-1]) {
				rank[j++] = ranking[i];
			}
		}
		
		int[] res = new int[player.length];
		int resIndex = 0;
		int rankIndex = rank.length - 1;
		
		while (resIndex < player.length && player[resIndex] < rank[rankIndex]) {
			res[resIndex++] = rankIndex + 2;
		}
		while (true) {
			while (resIndex < player.length && rankIndex >= 0 && player[resIndex] >= rank[rankIndex]) rankIndex--;
			if (resIndex < res.length) res[resIndex++] = rankIndex + 2;
			// ^ is this if necessary?
			if (resIndex >= res.length || player[resIndex]>=rank[0]) break;
		}
		while(resIndex < player.length)
			res[resIndex++] = 1;
		
		return res;
	}
}
