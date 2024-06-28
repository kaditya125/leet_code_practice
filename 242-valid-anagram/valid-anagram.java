import java.util.HashMap;
import java.util.Map;
class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length())
        {
            return false;
        }

        Map<Character, Integer> count = new HashMap<>();

        for(char c:s.toCharArray())
        {
            count.put(c, count.getOrDefault(c,0)+1);
        }

        for(char c : t.toCharArray())
        {
            if(count.containsKey(c))
            {
                count.put(c, count.get(c)-1);

                if(count.get(c)<0)
                {
                    return false;
                }
            }else{
                return false;
            }

        }
        

        for(int value: count.values())
        {
            if(value!=0)
            {
                return false;
            }
        }
        return true;
    }
}