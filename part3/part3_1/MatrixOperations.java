package part3.part3_1;

/**
 * Задание 3.1 — Операции с матрицами
 *
 * Тема: двумерные массивы (int[][]).
 *
 * Ключевая теория:
 *   - Двумерный массив — массив массивов. matrix[i][j] =
 *     элемент строки i, столбца j.
 *   - matrix.length — число строк, matrix[0].length — число столбцов.
 *   - Транспонирование: строки ↔ столбцы. result[j][i] = matrix[i][j].
 *   - Умножение матриц A(m×n) × B(n×p) = C(m×p):
 *     C[i][j] = Σ(A[i][k] × B[k][j]) для k от 0 до n-1.
 *   - Умножение возможно только если число столбцов A = числу строк B.
 *
 * Как запустить: нажмите ▶ рядом с main.
 *
 * Ожидаемый вывод:
 *
 * Матрица A (2x3):
 *    1   2   3
 *    4   5   6
 *
 * Транспонированная A (3x2):
 *    1   4
 *    2   5
 *    3   6
 *
 * Матрица B (3x2):
 *    7   8
 *    9  10
 *   11  12
 *
 * A * B (2x2):
 *   58  64
 *  139 154
 *
 * Сумма диагонали A*B: 212
 */

public class MatrixOperations {

    public static void print(int[][] matrix) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public static int[][] transpose(int[][] matrix) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        int aRows = a.length;
        int aCols = a[0].length;
        int bRows = b.length;
        int bCols = b[0].length;

        if (aCols != bRows) {
            System.out.println("Ошибка: размеры матриц несовместимы для умножения");
            return null;
        }

        int[][] result = new int[aRows][bCols];

        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                for (int k = 0; k < aCols; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public static int diagonalSum(int[][] matrix) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        int sum = 0;
        int minDim = Math.min(matrix.length, matrix[0].length);

        for (int i = 0; i < minDim; i++) {
            sum += matrix[i][i];
        }
        return sum;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] b = {
                {7,  8},
                {9,  10},
                {11, 12}
        };

        System.out.println("Матрица A (2x3):");
        print(a);

        System.out.println("\nТранспонированная A (3x2):");
        print(transpose(a));

        System.out.println("\nМатрица B (3x2):");
        print(b);

        int[][] c = multiply(a, b);
        System.out.println("\nA * B (2x2):");
        print(c);

        System.out.println("\nСумма диагонали A*B: " + diagonalSum(c));
    }
}