class Solution {
    public int maxArea(int[] height) {
       int max=Integer.MIN_VALUE;
       int left=0;
       int right= height.length-1;

       int area=0;
       while(left<right)
       {
           int heigh= Math.min(height[left],height[right]);
           int bredth=right-left;

           area=heigh*bredth;
           max= Math.max(max,area);

           if(height[left]<height[right])
           {
               left++;
           }else{
              right--;
           }
       } 

       return max;
    }
}