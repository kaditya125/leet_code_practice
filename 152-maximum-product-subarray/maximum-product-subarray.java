class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int res=1;
        for(int i=0;i<nums.length;i++)
        {
          res*=nums[i];
          if(res>max)
          {
              max=res;
          }
          if(nums[i]==0)
          {
              res=1;
          }
        }
        res=1;
        for(int i=nums.length-1;i>=0;i--)
        {
          res*=nums[i];
          if(res>max)
          {
              max=res;
          }
          if(nums[i]==0)
          {
              res=1;
          }
        }

        return max;
    }
}