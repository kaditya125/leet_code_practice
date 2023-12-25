class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // If there is an obstacle, set paths to 0
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1; // Starting point
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1]; // Initialize the first row
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j]; // Initialize the first column
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // General case
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

