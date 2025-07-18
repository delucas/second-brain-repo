package delucas.algorithms;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static Integer[] traverse(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
        	return result.toArray(new Integer[result.size()]);
        
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        
        while (left <= right && top <= bottom) {
            // Recorrer de izquierda a derecha
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            
            // Recorrer de arriba a abajo
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            // Recorrer de derecha a izquierda
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }
            
            // Recorrer de abajo a arriba
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result.toArray(new Integer[result.size()]);
	}

}
