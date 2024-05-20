package delucas.leetcode;

import java.util.HashMap;

import delucas.utils.Pair;

public class PointsInLine {

	public static int bruteForce(Pair[] points) {
		int res = 1;

		for (int i = 0; i < points.length; i++) {
			Pair ref = points[i];
			for (int j = i + 1; j < points.length; j++) {
				Pair ref2 = points[j];
				double slope = (ref.y - ref2.y) != 0 ? (ref.x - ref2.x) / (ref.y - ref2.y) : Double.POSITIVE_INFINITY;
				int max = 2;
				for (int k = j + 1; k < points.length; k++) {
					Pair current = points[k];
					double slope2 = (ref.y - current.y) != 0 ? (ref.x - current.x) / (ref.y - current.y)
							: Double.POSITIVE_INFINITY;
					if (slope == slope2) {
						max++;
					}
				}
				res = Math.max(res, max);
			}
		}

		return res;
	}

	public static int quadratic(Pair[] points) {
		int res = 1;

		for (int i = 0; i < points.length; i++) {
			HashMap<Double, Integer> count = new HashMap<Double, Integer>();
			int max = 0;
			Pair ref = points[i];
			for (int j = i + 1; j < points.length; j++) {
				Pair current = points[j];
				double slope = (ref.y - current.y) != 0 ? (ref.x - current.x) / (ref.y - current.y)
						: Double.POSITIVE_INFINITY;
				count.put(slope, count.getOrDefault(slope, 1) + 1);
			}
			for (Integer c : count.values()) {
				max = Math.max(max, c);
			}
			res = Math.max(res, max);
		}

		return res;
	}

}
