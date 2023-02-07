package delucas.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WordBreak {
	public static boolean recursive(final String s, final String[] words) {
		return recursive(s, words, 0);
	}

	private static boolean recursive(final String s, final String[] words, final int i) {
		if (i == s.length())
			return true;

		for (String word : words) {
			if (i + word.length() <= s.length()
			&& word.equals(s.substring(i, i + word.length()))
			&& recursive(s, words, i + word.length()))
				return true;
		}
		return false;
	}
	
	public static boolean topDown(final String s, final String[] words) {
		return topDown(s, words, 0, new HashMap<Integer, Boolean>());
	}

	private static boolean topDown(final String s, final String[] words, final int idx, final Map<Integer, Boolean> mem) {
		if (!mem.containsKey(idx)) {			
			if (idx == s.length())
				mem.put(idx, true);
			else {				
				for (String word : words) {
					if (idx + word.length() <= s.length()
							&& word.equals(s.substring(idx, idx + word.length()))
							&& recursive(s, words, idx + word.length()))
						mem.put(idx, true);
				}
				if (!mem.containsKey(idx)) mem.put(idx, true);
			}
		}
		return mem.get(idx);
	}

	public static boolean bottomUp(final String s, final String[] words) {
		int k = s.length();
		boolean[] table = new boolean[k + 1];
		table[0] = true;
		
		Set<String> wordsSet = new TreeSet<String>();
		wordsSet.addAll(Arrays.asList(words));
		
		for (int i = 1; i < k + 1; i++)
			for (int j = 0; j < i; j++)
				if (wordsSet.contains(s.substring(j, i)) && table[j]) {
					table[i] = true;
					break;
				}

		return table[k];
	}
	
}
