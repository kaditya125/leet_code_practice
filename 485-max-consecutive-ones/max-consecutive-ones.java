class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int onecount =0;
        int left=0;
        int max=0;

        for(int right=0;right<nums.length;right++)
        {
            if(nums[right]==1)
            {
                onecount++;
                max = Math.max(max,onecount);
            }
            else{
                onecount=0;
            }
        }
         return max;
    }
}