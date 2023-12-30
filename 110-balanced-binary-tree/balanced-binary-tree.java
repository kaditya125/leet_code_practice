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

    public int findheight(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left= findheight(root.left);
        int right = findheight(root.right);

        return Math.max(left, right)+1;
    }
    public boolean isBalanced(TreeNode root) {
         if(root==null)
         {
             return true;
         } 

         int left= findheight(root.left);
         int right= findheight(root.right);

         if(Math.abs(right-left)>1) 
         {
             return false;
         } 

         return isBalanced(root.left)&& isBalanced(root.right);   
    }
}