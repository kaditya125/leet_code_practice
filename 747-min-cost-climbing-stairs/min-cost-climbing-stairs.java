class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        // Base cases
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Calculate minimum cost for each step
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // The result is the minimum cost to reach the top
        return Math.min(dp[n-1], dp[n - 2]);
    }
}
