package ar.delucas.dp;

import java.util.Arrays;

public class Grasshopper {

	public static int solve(int[] values) {
		if (values.length == 0) {
			return 0;
		}
		
		int[] primes = getPrimesUpTo5000();

		int[] table = new int[values.length];

		for (int i = 0; i < values.length; i++) {
			int max = values[i];
			for (int j = 0; j < primes.length; j++) {
				int prev = i - primes[j];
				if (prev < 0) break;
				if (values[i] + table[prev] > max) {
					max = values[i] + table[prev];
				}
			}
			table[i] = max;
		}

		int ret = table[0];
		for (int i = 1; i < values.length; i++) {
			if (table[i] > ret) {
				ret = table[i];
			}
		}
		return Math.max(ret, 0);
	}

	public static int[] getPrimesUpTo5000() {
		int max = 5003;
		boolean[] isPrime = new boolean[max + 1];
		int count = 0;

		// Inicializar el array de booleanos
		for (int i = 2; i <= max; i++) {
			isPrime[i] = true;
		}

		// Criba de Eratóstenes
		for (int i = 2; i * i <= max; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= max; j += i) {
					isPrime[j] = false;
				}
			}
		}

		// Contar el número de primos
		for (int i = 2; i <= max; i++) {
			if (isPrime[i]) {
				count++;
			}
		}

		// Llenar el array de primos
		int[] primes = new int[count];
		int index = 0;
		for (int i = 2; i <= max; i++) {
			if (isPrime[i]) {
				primes[index++] = i;
			}
		}

		return primes;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getPrimesUpTo5000()));
	}
}
