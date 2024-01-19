class Solution {
    public int minFallingPathSum(int[][] matrix) {
          int n = matrix.length;

        // Start from the second row and update the matrix
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Calculate the minimum falling path sum for the current cell
                int minSum = matrix[i - 1][j];
                if (j > 0) {
                    minSum = Math.min(minSum, matrix[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    minSum = Math.min(minSum, matrix[i - 1][j + 1]);
                }

                // Update the current cell with the minimum falling path sum
                matrix[i][j] += minSum;
            }
        }

        // Find the minimum falling path sum in the last row
        int minPathSum = Integer.MAX_VALUE;
        for (int num : matrix[n - 1]) {
            minPathSum = Math.min(minPathSum, num);
        }

        return minPathSum;
    }
}