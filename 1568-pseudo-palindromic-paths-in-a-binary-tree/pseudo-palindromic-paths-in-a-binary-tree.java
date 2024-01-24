class Solution {
    // We use a variable to keep the count of pseudo-palindromic paths
    private int pseudoPalindromicPathCount;

    // Counter array to keep track of the frequency of each digit from 1-9
    private int[] digitFrequencyCounter;

    // This method starts the DFS traversal from the root to calculate the number of pseudo-palindromic paths in the tree
    public int pseudoPalindromicPaths(TreeNode root) {
        pseudoPalindromicPathCount = 0;
        digitFrequencyCounter = new int[10];
        depthFirstSearch(root);
        return pseudoPalindromicPathCount;
    }

    // Helper method for deep-first search
    private void depthFirstSearch(TreeNode node) {
        if (node == null) {
            return; // If the node is null, we backtrack as there is nothing to do further
        }
      
        // Increment the frequency of the current node's value
        digitFrequencyCounter[node.val]++;

        // If it's a leaf node, check if the path constitutes a pseudo-palindrome
        if (node.left == null && node.right == null) {
            if (isPseudoPalindrome()) {
                pseudoPalindromicPathCount++; // Increment the count if it is a pseudo-palindrome
            }
        } else {
            // Continue the traversal left and right in the tree if not a leaf node
            depthFirstSearch(node.left);
            depthFirstSearch(node.right);
        }

        // Backtrack: Decrement the frequency of the current node's value before returning to the parent
        digitFrequencyCounter[node.val]--;
    }

    // Check if the path represents a pseudo-palindrome
    private boolean isPseudoPalindrome() {
        int oddCount = 0; // This variable counts the number of digits which appear an odd number of times

        // A palindrome has at most one digit with an odd frequency
        for (int i = 1; i < 10; i++) {
            if (digitFrequencyCounter[i] % 2 == 1) {
                oddCount++;
            }
        }
      
        // If there is at most one odd frequency count, then we can form a pseudo-palindrome
        return oddCount < 2;
    } 
}