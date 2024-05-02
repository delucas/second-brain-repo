package delucas.dp;

public class FibonacciBU {

public int fibonacci(int n) {
	if (n < 2) {
		return n;
	}
	int anteriorDelAnterior = 0;
	int anterior = 1;
	int actual = 0;
	
	for (int i = 2; i <= n; i++) {
		actual = anteriorDelAnterior + anterior;
		anteriorDelAnterior = anterior;
		anterior = actual;
	}
	return actual;
}
	

/*
	if n < 2 {
		return n
	}
	prev2 := 0
	prev := 1
	var current int

	for i := 2; i <= n; i++ {
		current = prev2 + prev
		prev2 = prev
		prev = current
	}
	return current
}



 */

}
