import java.util.Arrays;

public class SetMatrixZeros {

    // Brute Force Approach (Time: O(N*M*(N+M)), Space: O(1))
    public static void setZeroesBruteForce(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // Mark entire row
                    for (int x = 0; x < m; x++) {
                        if (matrix[i][x] != 0) matrix[i][x] = -1;
                    }
                    // Mark entire column
                    for (int y = 0; y < n; y++) {
                        if (matrix[y][j] != 0) matrix[y][j] = -1;
                    }
                }
            }
        }
        // Replace -1 with 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Better Approach (Time: O(N*M), Space: O(N+M))
    public static void setZeroesBetter(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        // Mark rows and columns that should be zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        // Set marked rows and columns to zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Optimal Approach (Time: O(N*M), Space: O(1))
    public static void setZeroesOptimal(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;

        // Check if first row or column has zero
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) firstColZero = true;
        }
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) firstRowZero = true;
        }

        // Use first row and column as markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set zeroes using markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set first row and column if needed
        if (firstColZero) {
            for (int i = 0; i < n; i++) matrix[i][0] = 0;
        }
        if (firstRowZero) {
            for (int j = 0; j < m; j++) matrix[0][j] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        
        setZeroesOptimal(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
