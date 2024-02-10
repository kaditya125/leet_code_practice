class Solution {
    public int countSubstrings(String s) {
        int count=0;
        for(int j=0;j<s.length();j++)
        {
            for(int k=j+1;k<=s.length();k++)
            {
                if(checkbool(s.substring(j,k))==true)
                {
                    count++;
                }
            }
        }
        return count;
    }
    public boolean checkbool(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            char s1= s.charAt(i);
            char s2= s.charAt(s.length()-1-i);
            if(s1!=s2)
            {
                return false;
            }
        }
        return true;
    }
}