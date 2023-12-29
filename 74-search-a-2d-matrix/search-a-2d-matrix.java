class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // if(matrix==null || matrix.length==0 || matrix[0].length==0)
        // {
        //     return false;
        // }

        int left=0;
        int right= matrix[0].length-1;

        while(left<=matrix.length-1 && right>=0 )
        {
            if(matrix[left][right]==target)
            {
                return true;
            }else if(matrix[left][right]<target)
            {
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
}