class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map= new HashMap<>();
        int longestlength=0;
        for(int num:nums)
        {
            map.put(num,Boolean.FALSE);
        }
        for(int num:nums)
        {
            int currlength=1;
            int next = num+1;
            while(map.containsKey(next) && !map.get(next))
            {
                currlength++;
                map.put(next,Boolean.TRUE);
                next++;
            }

            int pre=num-1;
            while(map.containsKey(pre) && !map.get(pre))
            {
                currlength++;
                map.put(pre,Boolean.TRUE);
                pre--;
            }

            longestlength= Math.max(longestlength,currlength);
        }

        return longestlength;
    }
}