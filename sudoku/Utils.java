package sudoku;
import java.awt.Point;
import javax.swing.JTextField;

public class Utils {
    // Metode untuk menyalin matriks
    public static int[][] copyMatrix(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, matrix[i].length);
        }
        return copy;
    }

    // Metode untuk mendapatkan posisi sel
    public static Point getCellPosition(JTextField[][] cells, JTextField cell) {
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                if (cells[row][col] == cell) {
                    return new Point(row, col);
                }
            }
        }
        return null;
    }
}
