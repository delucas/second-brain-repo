package delucas.dp;

import java.util.HashMap;

public class HouseRobber3 {

	public static int recursiva(int[] houses) {
		return _recursiva(houses, 0);
	}

	private static int _recursiva(int[] houses, int i) {
		if (i >= houses.length || houses[i] == -1) {
			return 0;
		}
		
		int rob = houses[i]
				+ _recursiva(houses, (i*2+1)*2+1) + _recursiva(houses, (i*2+1)*2+2)
				+ _recursiva(houses, (i*2+2)*2+1) + _recursiva(houses, (i*2+2)*2+2);
		int noRob = 0 + _recursiva(houses, i*2+1) + _recursiva(houses, i*2+2);
		
		return Math.max(rob, noRob);
	}
	
	public static int dinamica(int[] houses) {
		HashMap<Integer, Integer> mem = new HashMap<Integer, Integer>();
		return _dinamica(houses, 0, mem);
	}

	private static int _dinamica(int[] houses, int i, HashMap<Integer, Integer> mem) {
		if (mem.containsKey(i)) {
			return mem.get(i);
		}
		
		if (i >= houses.length || houses[i] == -1) {
			mem.put(i, 0);
			return 0;
		}

		int rob = houses[i]
				+ _dinamica(houses, (i*2+1)*2+1, mem) + _dinamica(houses, (i*2+1)*2+2, mem)
				+ _dinamica(houses, (i*2+2)*2+1, mem) + _dinamica(houses, (i*2+2)*2+2, mem);
		int noRob = 0 + _dinamica(houses, i*2+1, mem) + _dinamica(houses, i*2+2, mem);
		
		mem.put(i, Math.max(rob, noRob));		
		return mem.get(i);
	}

}
