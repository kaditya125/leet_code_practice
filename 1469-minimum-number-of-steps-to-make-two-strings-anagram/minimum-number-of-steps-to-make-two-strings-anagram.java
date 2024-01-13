class Solution {
    public int minSteps(String s, String t) {

        int count= 0;
        HashMap<Character,Integer> map = new  HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            char ch= s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        } 

        for(int i=0;i<t.length();i++)
        {
            char ch=t.charAt(i);

            if (map.containsKey(ch) && map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
            } else {
                count++;
            }
        }

        return count;
    }
}