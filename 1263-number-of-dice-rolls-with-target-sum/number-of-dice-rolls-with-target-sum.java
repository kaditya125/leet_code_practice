class Solution {
    Integer[][] dp;
    int mod= 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        
        dp = new Integer[n+1][target+1];
        return targetres(n,k,target);
        
    }

    public int targetres(int n ,int k, int target)
    {
        if(n==0)
        {
            if(target==0)
            {
                return 1;
            }else{
                return 0;
            }
        }
        if(target<0)
        {
            return 0;
        }
        if(dp[n][target]!=null)
        {
            return dp[n][target];
        }
        int res=0;
        for(int i=1;i<=k;i++)
        {
           res+=targetres(n-1,k,target-i);
           res %=mod;
        }

        return dp[n][target]=res;
    }
}