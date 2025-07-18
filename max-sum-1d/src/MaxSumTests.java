import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MaxSumTests {

	@Test
	void testBU() {
		int[] arr = { 3, -2, 5, -1, 6, -3};
		assertEquals(11, maxSum1DBottomUp(arr));
	}
	
	@Test
	void testTD() {
		int[] arr = { 3, -2, 5, -1, 6, -3};
		assertEquals(11, maxSum1DTopDown(arr));
	}
	
	@Test
	void testBUSP() {
		int[] arr = { 3, -2, 5, -1, 6, -3};
		assertEquals(11, maxSum1DBottomUpSinglePass(arr));
	}
	
	public int maxSum1DTopDown(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> mem = new HashMap<Integer, Integer>();
        
        int maxSum = arr[0];
        // Llama a la función recursiva para cada índice
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, maxSum(i, arr, mem));
        }
        
        return maxSum;
    }

    // Función recursiva para calcular la suma máxima de una subsecuencia terminando en 'i'
    private int maxSum(int i, int[] arr, Map<Integer, Integer> mem) {
        // Caso base: si estamos en el primer elemento, la máxima suma es él mismo
        if (i == 0) {
            return arr[0];
        }
        
        // Verifica el resultado memorizado
        if (mem.containsKey(i)) {
            return mem.get(i);
        }
        
        // Caso recursivo: máxima suma al incluir arr[i] o comenzar desde arr[i]
        int includeCurrent = arr[i] + maxSum(i - 1, arr, mem); // Continuar la subsecuencia
        int startNew = arr[i]; // Iniciar una nueva subsecuencia desde i

        // Almacena el máximo entre continuar o empezar desde el índice actual
        mem.put(i, Math.max(includeCurrent, startNew));
        
        return mem.get(i);
    }

	@Test
	void testKadane() {
		int[] arr = { 3, -2, 5, -1, 6, -3};
		assertEquals(11, maxSum1DKadane(arr));
	}

	private int maxSum1DKadane(int[] arr) {
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		int i =0, j=arr.length-1;
		int max = sum;
		while(i < j) {
			if (arr[i] < arr[j]) {
				sum -= arr[i++];
			} else {
				sum -= arr[j--];
			}
			max = Math.max(max, sum);
		}
		
		return max;
	}
	
	private int maxSum1DBottomUpSinglePass(int[] arr) {
	    int currentSum = arr[0];
	    int maxSum = arr[0];
	    
	    for (int i = 1; i < arr.length; i++) {
	        currentSum = Math.max(arr[i], currentSum + arr[i]);
	        maxSum = Math.max(maxSum, currentSum);
	    }
	    
	    return maxSum;
	}

	private int maxSum1DBottomUp(int[] arr) {
		int[] table = new int[arr.length];
		
		table[0] = arr[0];
		for (int i = 1; i < table.length; i++) {
			table[i] = table[i-1] + arr[i];
		}
		
		int max = table[0];
		for (int i = 0; i < arr.length; i++) {
			for(int j = i; j < arr.length; j++) {			
	            if (i == 0) {
	                max = Math.max(max, table[j]);
	            } else {
	                max = Math.max(max, table[j] - table[i - 1]);
	            }
			}
		}
		
		return max;
	}

}
