import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 4) {
                return entry.getKey();
            }
        }
        return -1; 
    }
}
