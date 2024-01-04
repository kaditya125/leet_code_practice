class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int maxLength = 1;
        int start = 0;

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Check substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 2;
                maxLength = 2;
                start = i;
            }
        }

        // Check substrings of length 3 and above
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] > 0) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;

                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}
