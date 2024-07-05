class Solution {
    public int arrayNesting(int[] nums) {
        int n= nums.length;
        boolean[] visited =new boolean[n];

        int maxlength=0;

        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                int first = nums[i];
                int count=0;

                while(!visited[first])
                {
                    visited[first]=true;
                    first= nums[first];
                    count++;
                }
                 maxlength= Math.max(maxlength,count);
            }

           
        }

        return maxlength;
    }
}