class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();

        int left=0;
        int max=0;
        for(int right=0;right<s.length();right++)
        {
            if(!hs.contains(s.charAt(right)))
            {
                hs.add(s.charAt(right));
                max=Math.max(max,right-left+1);
            }
            else{
                while(s.charAt(left)!=s.charAt(right))
                {
                    hs.remove(s.charAt(left));
                    left++;
                }
                hs.remove(s.charAt(left));
                left++;
                hs.add(s.charAt(right));
            }
        }
        return max;
    }
}