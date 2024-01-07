import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Long, Integer>[] map = new HashMap[n];

        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }

                int n2 = map[i].getOrDefault(diff, 0);
                int n1 = map[j].getOrDefault(diff, 0);
                ans += n1;

                int freq = n1 + n2 + 1;
                map[i].put(diff, freq);
            }
        }

        return ans;
    }

    
}
