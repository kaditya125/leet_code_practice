class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        // if (n < 2) {
        //     return 0;
        // }
        // int max1 = Integer.MIN_VALUE;
        // int max2 = Integer.MIN_VALUE;
        // for (int num : nums) {
        //     if (num >= max1) {
        //         max2 = max1;
        //         max1 = num;
        //     } else if (num > max2) {
        //         max2 = num;
        //     }
        // }

        // return (max1 - 1) * (max2 - 1);
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num:nums)
        {
            pq.add(num);
        }

        int max1=pq.poll();
        int max2=pq.poll();

        return (max1-1)*(max2-1);
    }
}
