class Solution {
    public int fib(int n) {
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return 1;
        }
        int pre =1;
        int pre1=0;
        int res=0;

        for(int i=2;i<=n;i++)
        {
           res= pre+pre1;
           
            pre1=pre;
            pre=res;
        }
        return res;
    }
}