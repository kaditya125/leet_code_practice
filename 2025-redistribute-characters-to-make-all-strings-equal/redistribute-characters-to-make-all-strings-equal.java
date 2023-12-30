import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean makeEqual(String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (String str : words) {
            for (int i = 0; i < str.length(); i++) {  
                char ch = str.charAt(i);

                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {  
            int count = entry.getValue(); 
            if (count % words.length != 0) {
                return false;
            }
        }

        return true;
    }
}
