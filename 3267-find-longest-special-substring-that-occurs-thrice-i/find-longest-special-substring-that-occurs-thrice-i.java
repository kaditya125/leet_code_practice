import java.util.HashMap;

class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int result = -1;

        // Iterate over possible lengths of the substring from largest to smallest
        for (int len = n; len > 0; len--) {
            HashMap<String, Integer> frequencyMap = new HashMap<>();

            // Traverse the string and count occurrences of substrings of length 'len'
            for (int i = 0; i <= n - len; i++) {
                String sub = s.substring(i, i + len);

                // Check if the substring is special (all characters are the same)
                if (isSpecial(sub)) {
                    frequencyMap.put(sub, frequencyMap.getOrDefault(sub, 0) + 1);

                    // If a substring occurs at least 3 times, update the result
                    if (frequencyMap.get(sub) >= 3) {
                        result = len;
                        return result; // Return as soon as we find the maximum length
                    }
                }
            }
        }

        return result;
    }

    // Helper function to check if a string is special (all characters are the same)
    private boolean isSpecial(String str) {
        char firstChar = str.charAt(0);
        for (char c : str.toCharArray()) {
            if (c != firstChar) {
                return false;
            }
        }
        return true;
    }
}
