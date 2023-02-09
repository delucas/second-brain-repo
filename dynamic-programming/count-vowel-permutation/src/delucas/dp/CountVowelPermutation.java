package delucas.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import delucas.utils.MyMath;
import delucas.utils.Pair2;

public class CountVowelPermutation {

	private static final int BIG_PRIME = 1_000_000_007;
	static Map<Character, List<Character>> rules = new HashMap<Character, List<Character>>();

	static {
		List<Character> a = new LinkedList<Character>();
		a.add('e');

		List<Character> e = new LinkedList<Character>();
		e.add('a');
		e.add('i');

		List<Character> i = new LinkedList<Character>();
		i.add('a');
		i.add('e');
		i.add('o');
		i.add('u');

		List<Character> o = new LinkedList<Character>();
		o.add('i');
		o.add('u');

		List<Character> u = new LinkedList<Character>();
		u.add('a');

		List<Character> x = new LinkedList<Character>();
		x.add('a');
		x.add('e');
		x.add('i');
		x.add('o');
		x.add('u');

		rules.put('a', a);
		rules.put('e', e);
		rules.put('i', i);
		rules.put('o', o);
		rules.put('u', u);
		rules.put('x', x);
	}

	public static int recursive(int n) {
		return recursive(n, 'x');
	}

	private static int recursive(int n, Character previous) {
		if (n == 0)
			return 1;

		int sum = 0;
		for (Character each : rules.get(previous)) {
			sum += recursive(n - 1, each) % BIG_PRIME;
		}

		return sum % BIG_PRIME;
	}

	public static int topDown(int n) {
		return topDown(n, 'x', new HashMap<Pair2<Integer, Character>, Integer>());
	}

	private static int topDown(int n, Character previous, Map<Pair2<Integer, Character>, Integer> mem) {
		Pair2<Integer, Character> currentKey = new Pair2<Integer, Character>(n, previous);

		if (!mem.containsKey(currentKey)) {
			if (n == 0)
				mem.put(currentKey, 1);
			else {
				int sum = 0;
				for (Character each : rules.get(previous)) {
					sum += topDown(n - 1, each, mem) % BIG_PRIME;
				}
				mem.put(currentKey, sum % BIG_PRIME);
			}
		}
		return mem.get(currentKey);
	}

	public static int bottomUp(int n) {
		int[][] table = new int[n][5];

		for (int j = 0; j < 5; j++) {
			table[0][j] = 1;
		}
		int a = 0, e = 1, i = 2, o = 3, u = 4;

		for (int idx = 1; idx < table.length; idx++) {
			table[idx][a] = (table[idx - 1][e] + table[idx - 1][i] + table[idx - 1][u]) % BIG_PRIME;
			table[idx][e] = (table[idx - 1][a] + table[idx - 1][i]) % BIG_PRIME;
			table[idx][i] = (table[idx - 1][e] + table[idx - 1][o]) % BIG_PRIME;
			table[idx][o] = (table[idx - 1][i]) % BIG_PRIME;
			table[idx][u] = (table[idx - 1][i] + table[idx - 1][o]) % BIG_PRIME;
		}

		return MyMath.sum(table[n - 1]) % BIG_PRIME;
	}

	public static int optimizedBottomUp(int n) {
		if (n == 1)
			return 5;

		long[][] table = new long[2][5];

		for (int j = 0; j < 5; j++) {
			table[0][j] = 1;
		}
		int a = 0, e = 1, i = 2, o = 3, u = 4;

		for (int idx = 1; idx < n; idx++) {
			table[1][a] = (table[0][e] + table[0][i] + table[0][u]) % BIG_PRIME;
			table[1][e] = (table[0][a] + table[0][i]) % BIG_PRIME;
			table[1][i] = (table[0][e] + table[0][o]) % BIG_PRIME;
			table[1][o] = (table[0][i]) % BIG_PRIME;
			table[1][u] = (table[0][i] + table[0][o]) % BIG_PRIME;

			table[0] = Arrays.copyOf(table[1], 5);
		}

		return (int) (MyMath.sum(table[1]) % BIG_PRIME);
	}

	// For reference
	public static int superOptimizedBottomUp(int n) {
		int aCount = 1, eCount = 1, iCount = 1, oCount = 1, uCount = 1;

		for (int i = n - 1; i > 0; i--) {
			int newaCount = eCount % BIG_PRIME;
			int neweCount = (aCount + iCount) % BIG_PRIME;
			int newiCount = ((aCount + eCount) % BIG_PRIME + (oCount + uCount) % BIG_PRIME) % BIG_PRIME;
			int newoCount = (iCount + uCount) % BIG_PRIME;
			int newuCount = (aCount) % BIG_PRIME;

			aCount = newaCount;
			eCount = neweCount;
			iCount = newiCount;
			oCount = newoCount;
			uCount = newuCount;
		}

		return (((aCount + eCount) % BIG_PRIME + (iCount + uCount) % BIG_PRIME) % BIG_PRIME + oCount) % BIG_PRIME;
	}
}
