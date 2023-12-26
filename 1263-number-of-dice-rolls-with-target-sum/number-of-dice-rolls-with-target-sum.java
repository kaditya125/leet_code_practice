import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<String, Integer> memo;

    public int numRollsToTarget(int n, int k, int target) {
        memo = new HashMap<>();
        return helper(n, k, target);
    }

    private int helper(int n, int k, int target) {
        if (n == 0 || target <= 0) {
            return (n == 0 && target == 0) ? 1 : 0;
        }

        String key = n + "-" + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int res = 0;
        for (int i = 1; i <= k; i++) {
            if (target - i >= 0) {
                res = (res + helper(n - 1, k, target - i)) % 1000000007;
            }
        }

        memo.put(key, res);
        return res;
    }
}
