class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        }

        // Case 1: Rob the first house and exclude the last house
        int max1 = robHelper(nums, 0, n - 2);

        // Case 2: Do not rob the first house and include the last house
        int max2 = robHelper(nums, 1, n - 1);

        // Return the maximum of the two cases
        return Math.max(max1, max2);
    }

    private int robHelper(int[] nums, int start, int end) {
        int n = end - start + 1;

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[start];
        }

        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }

        return dp[n - 1];
    }
}
