class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] diff = new int[m][n];

        // Calculate the sum of ones and zeros in rows and columns
        int[] onesRow = new int[m];
        int[] zerosRow = new int[m];
        int[] onesCol = new int[n];
        int[] zerosCol = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                onesRow[i] += grid[i][j];
                zerosRow[i] += 1 - grid[i][j];
                onesCol[j] += grid[i][j];
                zerosCol[j] += 1 - grid[i][j];
            }
        }

        // Calculate the difference matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
            }
        }

        return diff;
    }
}
