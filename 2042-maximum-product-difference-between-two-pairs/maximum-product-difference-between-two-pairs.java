class Solution {
    public int maxProductDifference(int[] nums) {
        int a=Integer.MIN_VALUE;
        int b=Integer.MIN_VALUE;
        int c=Integer.MAX_VALUE;
        int d=Integer.MAX_VALUE;

        for(int num:nums)
        {
            if(num>a)
            {
                b=a;
                a=num;
            }else if(num>b)
            {
                b=num;
            }

            if(num<c)
            {
                d=c;
                c=num;
            }else if(num<d)
            {
                d=num;
            }
        }

        return (a*b)-(c*d);
    }
}