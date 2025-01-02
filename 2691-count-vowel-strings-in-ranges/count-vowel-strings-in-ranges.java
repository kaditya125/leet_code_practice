class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        // Define vowels
        String vowels = "aeiou";

        // Create a prefix sum array
        int[] prefixSum = new int[words.length + 1];

        // Fill the prefix sum array
        for (int i = 0; i < words.length; i++) {
            if (isVowel(words[i].charAt(0), vowels) && isVowel(words[i].charAt(words[i].length() - 1), vowels)) {
                prefixSum[i + 1] = prefixSum[i] + 1;
            } else {
                prefixSum[i + 1] = prefixSum[i];
            }
        }

        // Prepare the result array
        int[] result = new int[queries.length];

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            result[i] = prefixSum[ri + 1] - prefixSum[li];
        }

        return result;
    }

    // Helper method to check if a character is a vowel
    private boolean isVowel(char c, String vowels) {
        return vowels.indexOf(c) != -1;
    }
}
