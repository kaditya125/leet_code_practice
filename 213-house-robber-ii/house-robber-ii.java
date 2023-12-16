class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        }

        // Rob the first house and exclude the last house
        int max1 = robHelper(nums, 0, n - 2);
        
        // Do not rob the first house and include the last house
        int max2 = robHelper(nums, 1, n - 1);
        
        return Math.max(max1, max2);
    }
    
    private int robHelper(int[] nums, int start, int end) {
        int prevMax = 0;
        int currMax = 0;

        for (int i = start; i <= end; i++) {
            int temp = currMax;
            currMax = Math.max(currMax, prevMax + nums[i]);
            prevMax = temp;
        }

        return currMax;
    }
}
