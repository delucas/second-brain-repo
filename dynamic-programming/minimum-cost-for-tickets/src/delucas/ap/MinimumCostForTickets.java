package delucas.ap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import delucas.utils.MyMath;

public class MinimumCostForTickets {

	public static int recursive(final Integer[] trainDays, final int[] costs, final int days) {
		Set<Integer> trainDaysSet = new TreeSet<Integer>();
		trainDaysSet.addAll(Arrays.asList(trainDays));
		return recursive(trainDaysSet, costs, days, 0);
	}

	private static int recursive(final Set<Integer> trainDays, final int[] costs, final int totalDays, final int currentDay) {
		if (currentDay >= totalDays) return 0;
		
		if (!trainDays.contains(currentDay)) {
			return recursive(trainDays, costs, totalDays, currentDay + 1);
		} else {
			return MyMath.min(new int[] {
					costs[0] + recursive(trainDays, costs, totalDays, currentDay + 1),
					costs[1] + recursive(trainDays, costs, totalDays, currentDay + 7),
					costs[2] + recursive(trainDays, costs, totalDays, currentDay + 30),
			});
		}
	}
	
	public static int topDown(final Integer[] trainDays, final int[] costs, final int days) {
		Set<Integer> trainDaysSet = new TreeSet<Integer>();
		trainDaysSet.addAll(Arrays.asList(trainDays));
		return topDown(trainDaysSet, costs, days, 0, new HashMap<Integer, Integer>());
	}

	private static int topDown(final Set<Integer> trainDays, final int[] costs, final int totalDays, final int currentDay, final Map<Integer, Integer> mem) {
		if (!mem.containsKey(currentDay)) {
			if (currentDay >= totalDays)
				mem.put(currentDay, 0);
			else if (!trainDays.contains(currentDay))
				mem.put(currentDay, recursive(trainDays, costs, totalDays, currentDay + 1));
			else
				mem.put(currentDay, MyMath.min(new int[] {
						costs[0] + recursive(trainDays, costs, totalDays, currentDay + 1),
						costs[1] + recursive(trainDays, costs, totalDays, currentDay + 7),
						costs[2] + recursive(trainDays, costs, totalDays, currentDay + 30),
				}));
		}
		return mem.get(currentDay);
	}
	
	public static int bottomUp(final Integer[] trainDays, final int[] costs, final int days) {
		Set<Integer> trainDaysSet = new TreeSet<Integer>();
		trainDaysSet.addAll(Arrays.asList(trainDays));
		
		int[] table = new int[days];
		
		for (int i = 0; i < table.length; i++) {
			if (!trainDaysSet.contains(i)) {
				table[i] = i - 1 >= 0 ? table[i-1] : 0;
			} else {
				table[i] = MyMath.min(new int[] {
						costs[0] + (i - 1 >= 0 ? table[i-1] : 0),
						costs[1] + (i - 7 >= 0 ? table[i-7] : 0),
						costs[2] + (i - 30 >= 0 ? table[i-30] : 0),
				});
			}
		}
		
		return table[days - 1];
	}
}
