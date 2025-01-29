import java.util.*;

public class PascalTriangle {

    // Brute Force Approach (Time: O(N^3), Space: O(1))
    public static List<List<Integer>> generateBruteForce(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(getPascalValue(i, j));
            }
            triangle.add(row);
        }
        return triangle;
    }

    private static int getPascalValue(int row, int col) {
        if (col == 0 || col == row) return 1;
        return getPascalValue(row - 1, col - 1) + getPascalValue(row - 1, col);
    }

    // Better Approach (Time: O(N^2), Space: O(N^2))
    public static List<List<Integer>> generateBetter(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));
            for (int j = 1; j < i; j++) {
                row.set(j, triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
            }
            triangle.add(row);
        }
        return triangle;
    }

    // Optimal Approach (Time: O(N^2), Space: O(1))
    public static List<List<Integer>> generateOptimal(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            int value = 1;
            for (int j = 0; j <= i; j++) {
                row.add(value);
                value = value * (i - j) / (j + 1);
            }
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generateOptimal(numRows);
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}