package delucas.leetcode;

public class ArrayNesting {

	public static int bruteForce(int[] input) {
		int maxLength = 0;

		for (int i = 0; i < input.length; i++) {
			int length = 1;
			int index = i;
			while (input[index] != i) {
				length++;
				index = input[index];
			}
			maxLength = Math.max(maxLength, length);
		}
		return maxLength;
	}

	public static int memoized(int[] input) {
		int maxLength = 0;
		boolean[] visited = new boolean[input.length];

		for (int i = 0; i < input.length; i++) {
			int length = 1;
			int index = i;
			if (!visited[index]) {
				while (input[index] != i) {
					length++;
					visited[index] = true;
					index = input[index];
				}
				maxLength = Math.max(maxLength, length);
			}
		}
		return maxLength;
	}
	
	public static int discardingElements(int[] input) {
	    int maxLength = 0;
	    
	    for (int i = 0; i < input.length; i++) {
	        if (input[i] >= 0) {
	            int length = 0;
	            int index = i;
	            while (input[index] >= 0) {
	                int nextIndex = input[index];
	                input[index] = -1;
	                index = nextIndex;
	                length++;
	            }
	            maxLength = Math.max(maxLength, length);
	        }
	    }
	    return maxLength;
	}
}
