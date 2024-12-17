class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
         int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        // Priority queue can be avoided, directly using loop from 'z' to 'a'
        for (int i = 25; i >= 0; i--) {
            while (freq[i] > 0) {
                // Add the current character `repeatLimit` times or less
                int count = Math.min(freq[i], repeatLimit);
                while (count-- > 0) {
                    result.append((char) (i + 'a'));
                    freq[i]--;
                }

                // Check if the next character in the result would violate the limit
                if (freq[i] > 0) {
                    // Find the next largest character to interleave
                    boolean found = false;
                    for (int j = i - 1; j >= 0; j--) {
                        if (freq[j] > 0) {
                            result.append((char) (j + 'a'));
                            freq[j]--;
                            found = true;
                            break;
                        }
                    }
                    // If no smaller character is available, we can't add more characters
                    if (!found) {
                        return result.toString();
                    }
                }
            }
        }

        return result.toString();
    }
}