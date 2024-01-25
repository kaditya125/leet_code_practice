class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m= text1.length();
        int n= text2.length();
        int[][] arr = new int[m+1][n+1];
       for(int i=0;i<m+1;i++)
        arr[i][0]=0;
        for(int i=0;i<n+1;i++)
        {
            arr[0][i]=0;
        }
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1) )
                {
                    arr[i][j]= arr[i-1][j-1]+1;
                
                }else 
                    arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
                
            }
        }
        return arr[m][n];

    }
}