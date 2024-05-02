package delucas.dp;

import java.util.HashMap;
import java.util.Map;

public class FibonacciTD {

public int fibonacci(int n) {
	return fibonacci(n, new HashMap<Integer, Integer>());
}

private int fibonacci(int n, Map<Integer, Integer> mem) {
	int key = n;
	if (mem.containsKey(key)) {
		return mem.get(key);
	}
	if (n < 2) {
		mem.put(key, n);
	} else {		
		mem.put(key, fibonacci(n-1, mem) + fibonacci(n-2, mem));
	}
	return mem.get(key);
}
	
}
