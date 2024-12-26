class Solution {
    public int findTargetSumWays(int[] nums, int target) {
      int totalSum = 0;
        
        // Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }
        
        // If target is out of the possible range or (target + totalSum) is odd
        if (target > totalSum || target < -totalSum || (totalSum + target) % 2 != 0) {
            return 0;
        }

        // Calculate the subset sum P
        int P = (target + totalSum) / 2;

        // DP array to count the number of ways to get sum P
        int[] dp = new int[P + 1];
        dp[0] = 1; // There is one way to get sum 0, which is by selecting no elements

        // Fill the DP table
        for (int num : nums) {
            for (int j = P; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        // The result is the number of ways to get sum P
        return dp[P];
      
    }
}