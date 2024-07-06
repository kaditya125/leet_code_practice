import java.util.*;

public class Solution {
    
    private Map<String, Boolean> memo = new HashMap<>();
    
    public boolean find(int[] stones, int curr, int lastJump, Map<Integer, Integer> map) {
        String key = curr + "," + lastJump;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        for (int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
            if (jump > 0) {
                int nextPosition = stones[curr] + jump;
                if (nextPosition == stones[stones.length - 1]) {
                    return true;
                }
                
                if (map.containsKey(nextPosition)) {
                    int nextIndex = map.get(nextPosition);
                    if (find(stones, nextIndex, jump, map)) {
                        memo.put(key, true);
                        return true;
                    }
                }
            }
        }
        
        memo.put(key, false);
        return false;
    }
    
    public boolean canCross(int[] stones) {
        int n = stones.length;

        if (stones[1] != 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        return find(stones, 0, 0, map);
    }
    

}
