package delucas.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import delucas.utils.MyMath;
import delucas.utils.Pair2;

public class CountSortedVowelString {

	public static int mathematical(int n) {
		return MyMath.fact(5 + n - 1) / (MyMath.fact(n) * MyMath.fact(4));
	}

	public static int recursive(int n) {
		return recursive(n, ' ');
	}

	private static int recursive(int n, char last) {
		if (n == 0)
			return 1;
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		int total = 0;

		for (int i = 0; i < vowels.length; i++) {
			char vowel = vowels[i];
			if (last <= vowel)
				total += recursive(n - 1, vowel);
		}
		return total;
	}

	public static int topDown(int n) {
		return topDown(n, ' ', new HashMap<Pair2<Integer, Character>, Integer>());
	}

	private static int topDown(int n, char last, Map<Pair2<Integer, Character>, Integer> mem) {
		Pair2<Integer, Character> currentKey = new Pair2<Integer, Character>(n, last);
		if (!mem.containsKey(currentKey)) {
			if (n == 0)
				return 1;
			else {
				char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
				int total = 0;

				for (int i = 0; i < vowels.length; i++) {
					char vowel = vowels[i];
					if (last <= vowel) {
						int val = topDown(n - 1, vowel, mem);
						mem.put(currentKey, val);
						total += val;
					}
				}
				return total;
			}
		}
		return mem.get(currentKey);
	}

	public static int bottomUp(final int n) {
		int[][] table = new int[n][5];
		for (int j = 0; j < table[0].length; j++)
			table[0][j] = 1;

		for (int i = 1; i < table.length; i++) {
			table[i][0] = table[i - 1][0] + table[i - 1][1] + table[i - 1][2] + table[i - 1][3] + table[i - 1][4];
			table[i][1] = table[i - 1][1] + table[i - 1][2] + table[i - 1][3] + table[i - 1][4];
			table[i][2] = table[i - 1][2] + table[i - 1][3] + table[i - 1][4];
			table[i][3] = table[i - 1][3] + table[i - 1][4];
			table[i][4] = table[i - 1][4];
		}
		return MyMath.sum(table[n-1]);
	}
	
	public static int optimizedBottomUp(final int n) {
		int[][] table = new int[2][5];
		for (int j = 0; j < table[0].length; j++)
			table[0][j] = 1;
		
		for (int i = 1; i < n; i++) {
			table[1][0] = table[0][0] + table[0][1] + table[0][2] + table[0][3] + table[0][4];
			table[1][1] = table[0][1] + table[0][2] + table[0][3] + table[0][4];
			table[1][2] = table[0][2] + table[0][3] + table[0][4];
			table[1][3] = table[0][3] + table[0][4];
			table[1][4] = table[0][4];
			
			table[0] = Arrays.copyOf(table[1], table[1].length);
		}
		return MyMath.sum(table[1]);
	}
}
