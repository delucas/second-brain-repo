package zapallos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

/**
 * 
 */
class Resultado {

	public Integer ganancia;
	public Integer cajasCompradas;
	public int[] cajasPorAgricultor;

	public Resultado(Integer ganancia, Integer cajasCompradas, int[] cajasPorAgricultor) {
		super();
		this.ganancia = ganancia;
		this.cajasCompradas = cajasCompradas;
		this.cajasPorAgricultor = cajasPorAgricultor;
	}

	@Override
	public String toString() {
		return "Resultado [ganancia=" + ganancia + ", cajasCompradas=" + cajasCompradas + ", cajasPorAgricultor="
				+ Arrays.toString(cajasPorAgricultor) + "]";
	}

	public Resultado dup() {
		return new Resultado(ganancia, cajasCompradas, Arrays.copyOf(cajasPorAgricultor, cajasPorAgricultor.length));
	}

}

class ZapallosTests {

	@Test
	public void testCalcularGanancia() {
		// Definimos el ejemplo de entrada
		int M = 8; // Capacidad del camión (cajas)
		int[][] costosAgricultores = { { 3, 12, 8, 10 }, // Agricultor 1
				{ 14, 2, 7, 15, 14, 10, 1 }, // Agricultor 2
				{ 12, 8, 1, 15, 12 }, // Agricultor 3
				{ 12, 13, 14 }, // Agricultor 4
				{ 11, 9, 8, 9, 1, 10 } // Agricultor 5
		};

		// Definimos los resultados esperados
		int gananciaEsperada = 23;
		int cajasCompradasEsperadas = 7;
		int[] cajasPorAgricultorEsperadas = { 1, 3, 3, 0, 0 };

		// Llamamos al método que estamos probando
		Resultado resultado = calcularGanancia(M, costosAgricultores);

		// Verificamos que la ganancia obtenida sea la esperada
		assertEquals(gananciaEsperada, resultado.ganancia);

		// Verificamos que el número de cajas compradas sea el correcto
		assertEquals(cajasCompradasEsperadas, resultado.cajasCompradas);

		// Verificamos que el número de cajas por agricultor sea el esperado
		assertArrayEquals(cajasPorAgricultorEsperadas, resultado.cajasPorAgricultor);

	}

	public Resultado calcularGanancia(int m, int[][] costosAgricultores) {
		return calcular(costosAgricultores, 0, 0, m, new HashMap<String, Resultado>());
	}
	
	private Resultado calcular(int[][] costosAgricultores, int i, int j, int m, HashMap<String, Resultado> mem) {
	
		String key = i + "-" + j + "-" + m;
		if (mem.containsKey(key)) {
			return mem.get(key);
		}
	
		// aquí no puedo comprar
		if (m <= 0 || i >= costosAgricultores.length || j >= costosAgricultores[i].length) {
			mem.put(key, new Resultado(0, 0, new int[costosAgricultores.length]));
			return mem.get(key);
		}
	
		// compro
		Resultado r1 = calcular(costosAgricultores, i, j + 1, m - 1, mem).dup();
		r1.ganancia += (10 - costosAgricultores[i][j]);
		r1.cajasCompradas++;
		r1.cajasPorAgricultor[i]++;
	
		// no compro y paso al próximo
		Resultado r2 = calcular(costosAgricultores, i + 1, 0, m, mem);
	
		Resultado mejorResultado = (r1.ganancia > r2.ganancia
				|| (r1.ganancia == r2.ganancia && r1.cajasCompradas <= r2.cajasCompradas)) ? r1 : r2;
		mem.put(key, mejorResultado);
	
		return mem.get(key);
	}

}
