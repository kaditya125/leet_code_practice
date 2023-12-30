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
    public boolean checkSym(TreeNode left, TreeNode right)
    {
        if(left==null && right==null)
        {
            return true;
        }
        if(left ==null || right == null)
        {
            return false;
        }
        if(left.val!=right.val)
        {
            return false;
        }

        if(checkSym(left.left, right.right)&&checkSym(left.right,right.left))
        {
            return true;
        }else{
            return false;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        {
            return true;
        }

        return checkSym(root.left, root.right);
    }
}