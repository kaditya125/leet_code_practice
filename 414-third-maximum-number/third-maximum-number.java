import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        if (set.size() < 3) {
            int max = Integer.MIN_VALUE;
            for (int num : set) {
                max = Math.max(max, num);
            }
            return max;
        }

        for (int num : set) {
            que.add(num);
            if (que.size() > 3) {
                que.remove(); 
            }
        }

        return que.peek();
    }
}
