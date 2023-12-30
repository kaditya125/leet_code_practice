class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int zerocount=0;
        int maxcount=Integer.MIN_VALUE;

        for(int right=0;right<nums.length;right++ )
        {
            if(nums[right]==0)
            {
                zerocount++;
            }

            while(zerocount>k)
            {

            if(nums[left]==0)
            {
                zerocount--;
            }
            left++;
            }

            maxcount= Math.max(maxcount,right-left+1);
        }
       return maxcount;
    }
}