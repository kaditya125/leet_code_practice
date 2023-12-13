class Solution {
    public int numSpecial(int[][] mat) {
        int n= mat.length;
        int m=mat[0].length;
        int special=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==1)
                {
                    int col=0;
                    int row=0;
                    for(int k=0;k<n;k++)
                    {
                        col+=mat[k][j];
                    }
                    for(int k=0;k<m;k++)
                    {
                        row+=mat[i][k];
                    }

                    if(col==1 && row==1)
                    {
                        special++;
                    }
                }
            }
        }
        return special;
    }
}