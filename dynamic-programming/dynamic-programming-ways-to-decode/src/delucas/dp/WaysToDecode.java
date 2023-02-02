package delucas.dp;

import java.util.HashMap;
import java.util.Map;

import delucas.utils.MyMath;

public class WaysToDecode {
	public static int recursive(final String s) {
		return recursive(s, 0);
	}
	
	private static int recursive(final String s, final int idx) {
		if (s.length() == idx) {
			return 1;
		} else if (s.charAt(idx) == '0') {
			return 0;
		} else if (idx+1 < s.length()
				&& MyMath.between(Integer.parseInt(s.substring(idx, idx+2)), 10, 26)) {
			return recursive(s, idx + 1) + recursive(s, idx + 2); 
		} else {
			return recursive(s, idx + 1);
		}
	}
	
	public static int topDown(final String s) {
		return topDown(s, 0, new HashMap<Integer, Integer>());
	}
	
	private static int topDown(final String s, final int idx, final Map<Integer, Integer> mem) {
		if (!mem.containsKey(idx)) {
			if (s.length() == idx) {
				mem.put(idx, 1);
			} else if (s.charAt(idx) == '0') {
				mem.put(idx, 0);
			} else if (idx+1 < s.length()
					&& MyMath.between(Integer.parseInt(s.substring(idx, idx+2)), 10, 26)) {
				mem.put(idx, topDown(s, idx + 1, mem) + topDown(s, idx + 2, mem)); 
			} else {
				mem.put(idx, topDown(s, idx + 1, mem));
			}
		}
		return mem.get(idx);
	}
	
	public static int bottomUp(final String s) {
		int n = s.length();
		int[] table = new int[n];
		
		if (s.charAt(0) == '0') return 0;
		if (s.length() == 1) return 1;
		
		table[0] = 1;
		table[1] = bti(s.charAt(1) != '0')
				+ bti(MyMath.between(Integer.parseInt(s.substring(0, 2)), 10, 26));
		
		for (int i = 2; i < table.length; i++) {
			if (s.charAt(i) != '0')
				table[i] += table[i-1];
			if (MyMath.between(Integer.parseInt(s.substring(i-1, i+1)), 10, 26))
				table[i] += table[i-2];
		}		
		
		return table[n-1];
	}
	
	public static int optimizedBottomUp(final String s) {
		int n = s.length();
		
		int prevPrev;
		int prev;
		int curr = 0;
		
		if (s.charAt(0) == '0') return 0;
		if (s.length() == 1) return 1;
		
		prevPrev = 1;
		prev = bti(s.charAt(1) != '0')
				+ bti(MyMath.between(Integer.parseInt(s.substring(0, 2)), 10, 26));
		
		for (int i = 2; i < n; i++) {
			if (s.charAt(i) != '0')
				curr += prev;
			if (MyMath.between(Integer.parseInt(s.substring(i-1, i+1)), 10, 26))
				curr += prevPrev;
			
			prevPrev = prev;
			prev = curr;
			curr = 0;
		}
		return prev;
	}

	private static int bti(boolean b) {
		return b ? 1 : 0;
	}	
}
