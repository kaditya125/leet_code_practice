class Solution {
    public int lengthOfLastWord(String s) {
        int length=0;
        String str1="";
        for(String str: s.split(" "))
        {
              str1=str;
        }

        return str1.length();
    }
}