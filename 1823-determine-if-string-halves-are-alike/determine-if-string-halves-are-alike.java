class Solution {
    public boolean halvesAreAlike(String s) {
       int n=s.length();
       int half=n/2;
       String str1= s.substring(0,half);
       String str2= s.substring(half,n);
    int count1=0;
    int count2=0;
        for(int i=0;i<str1.length();i++)
        {
            char ch=str1.charAt(i);
            if(ch=='a' || ch=='e' || ch== 'i' || ch== 'o' || ch=='u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            {
                count1++;
            }

        }
         for(int i=0;i<str2.length();i++)
        {
            char ch=str2.charAt(i);
            if(ch=='a' || ch=='e' || ch== 'i' || ch== 'o' || ch=='u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            {
                count2++;
            }

        }

        if(count1==count2)
        {
            return true;
        }
        return false;
    }
}