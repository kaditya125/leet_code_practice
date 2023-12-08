/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null||nums.length==0)
        {
            return null;
        }

        return constructBinaryTree(nums,0,nums.length-1);
    }

    public TreeNode constructBinaryTree(int nums[],int left,int right){
        if(left>right)
        {
            return null;
        }

        int maxindex= findmaxindex(nums,left,right);

        TreeNode root= new TreeNode(nums[maxindex]);
        root.left=constructBinaryTree(nums,left,maxindex-1);
        root.right=constructBinaryTree(nums,maxindex+1,right);

        return root;
    }

    public int findmaxindex(int nums[],int left,int right)
    {
        int index= left;
        for(int i=left;i<=right;i++){
            if(nums[i]>=nums[index])
            {
                index=i;
            }
        }
        return index;
    }
}