class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if (root == null) {
            return "";
        }

        str.append(root.val);

        if (root.left != null || root.right != null) {
            str.append("(");
            str.append(tree2str(root.left));
            str.append(")");

            if (root.right != null) {
                str.append("(");
                str.append(tree2str(root.right));
                str.append(")");
            }
        }

        return str.toString();
    }
}
