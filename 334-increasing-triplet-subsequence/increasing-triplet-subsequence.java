class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n= nums.length;

        int[] left = new int[n];
        int[] right= new int[n];

        left[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            left[i]=Math.min(nums[i],left[i-1]);
        }

        right[n-1]=nums[n-1];
        for(int j=n-2;j>=0;j--)
        {
            right[j]=Math.max(nums[j],right[j+1]);
        }

        for(int i=0;i<n;i++)
        {
            if(nums[i]>left[i] && nums[i]<right[i])
            {
                return true;
            }
        }

        return false;
    }
}