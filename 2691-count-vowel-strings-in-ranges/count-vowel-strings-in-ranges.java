class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        String vowels = "aeiou";

        int[] prefixSum = new int[words.length + 1];

        for (int i = 0; i < words.length; i++) {
            if (isVowel(words[i].charAt(0), vowels) && isVowel(words[i].charAt(words[i].length() - 1), vowels)) {
                prefixSum[i + 1] = prefixSum[i] + 1;
            } else {
                prefixSum[i + 1] = prefixSum[i];
            }
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            result[i] = prefixSum[ri + 1] - prefixSum[li];
        }

        return result;
    }

    private boolean isVowel(char c, String vowels) {
        return vowels.indexOf(c) != -1;
    }
}
