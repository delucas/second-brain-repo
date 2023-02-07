package delucas.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BoxStack {
	public static int recursive(final Box[] boxes) {
		Arrays.sort(boxes, Collections.reverseOrder());
		return recursive(boxes, 0);
	}

	private static int recursive(final Box[] boxes, final int idx) {
		Box current = boxes[idx];

		if (idx == boxes.length - 1)
			return current.h;
		
		int bestStack = 0;
		for (int i = idx; i < boxes.length; i++) {
			Box box = boxes[i];
			if (box.canBeStackedOn(current))
				bestStack = Math.max(bestStack, recursive(boxes, i));
		}

		return current.h + bestStack;
	}
	
	public static int topDown(final Box[] boxes) {
		Arrays.sort(boxes, Collections.reverseOrder());
		return topDown(boxes, 0, new HashMap<Integer, Integer>());
	}

	private static int topDown(final Box[] boxes, final int idx, final Map<Integer, Integer> mem) {
		if (!mem.containsKey(idx)) {
			Box current = boxes[idx];
			if (idx == boxes.length - 1)
				mem.put(idx, current.h);
			else {
				int bestStack = 0;
				for (int i = idx; i < boxes.length; i++) {
					Box box = boxes[i];
					if (box.canBeStackedOn(current))
						bestStack = Math.max(bestStack, topDown(boxes, i, mem));
				}
		
				mem.put(idx, current.h + bestStack);
			}
		}
		return mem.get(idx);
	}
	
	public static int bottomUp(final Box[] boxes) {
		Arrays.sort(boxes);
		int n = boxes.length;
		int[] table = new int[n];
		
		for (int i = 0; i < table.length; i++) {
			table[i] = boxes[i].h;
			for (int j = 0; j < i; j++) {
				if (boxes[j].canBeStackedOn(boxes[i]))
					table[i] = Math.max(table[i], boxes[i].h + table[j]);
			}
		}
		return table[n-1];
	}
}
