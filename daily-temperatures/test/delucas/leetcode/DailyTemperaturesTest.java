package delucas.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class DailyTemperaturesTest {

    @Test
    public void testExample1() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};
        assertArrayEquals(expected, DailyTemperatures.findWarmerDays(temperatures));
    }

    @Test
    public void testExample2() {
        int[] temperatures = {30, 40, 50, 60};
        int[] expected = {1, 1, 1, 0};
        assertArrayEquals(expected, DailyTemperatures.findWarmerDays(temperatures));
    }

    @Test
    public void testExample3() {
        int[] temperatures = {30, 60, 90};
        int[] expected = {1, 1, 0};
        assertArrayEquals(expected, DailyTemperatures.findWarmerDays(temperatures));
    }
}
