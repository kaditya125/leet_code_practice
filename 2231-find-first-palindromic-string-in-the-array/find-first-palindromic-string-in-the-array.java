class Solution {
    public String firstPalindrome(String[] words) {
          for (String word : words) {
            if (isPalindromic(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindromic(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}