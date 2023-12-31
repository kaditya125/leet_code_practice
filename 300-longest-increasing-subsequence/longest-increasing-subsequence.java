class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;

        int[] dp = new int[n];
        int maxlen=0;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    if(dp[j]+1>dp[i])
                    {
                        dp[i]=dp[j]+1;
                    }
                }
            }
        }
        for(int i=0;i<dp.length;i++)
        {
            if(dp[i]>maxlen)
            {
                maxlen=dp[i];
            }
        }
        return maxlen+1;
    }
}