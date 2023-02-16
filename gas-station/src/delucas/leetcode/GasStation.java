package delucas.leetcode;

public class GasStation {
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
		
		int res = 0, total = 0, sum = 0;
		for (int i = 0; i < n; i++) {
			total += gas[i] - cost[i];
			sum += gas[i] - cost[i];
			if (total < 0) {
				total = 0;
				res = i+1;
			}
		}
		return sum < 0 ? -1 : res;
	}
	public int canCompleteCircuitUnoptimized(int[] gas, int[] cost) {
    	int n = gas.length;
		int[] diff = new int[n];
		for (int i = 0; i < diff.length; i++) {
			diff[i] = gas[i] - cost[i];
		}
		
		for (int i = 0; i < n; i++) {
			if (diff[i] < 0) continue;
			int tank = diff[i];
			for (int j = 1; j < n; j++) {
				tank += diff[(i+j)%n];
				if (tank < 0) break;
			}
			if (tank >= 0) return i;
		}
		return -1;
    }
}
