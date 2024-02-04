class Solution {
    public String minWindow(String s, String t) {
          // Check if string t is empty
        if (t.length() == 0) {
            return "";
        }

        // Frequency map for characters in t
        Map<Character, Integer> mpt = new HashMap<>();

        // Frequency map for characters in the current window
        Map<Character, Integer> mps = new HashMap<>();

        // Populate frequency map for characters in t
        for (int i = 0; i < t.length(); i++) {
            char charInT = t.charAt(i);
            mpt.put(charInT, mpt.getOrDefault(charInT, 0) + 1);
        }

        // Variables for tracking required characters
        int cur = 0, total = mpt.size();

        // Pointers for the sliding window
        int i = 0, j = 0;

        // Variables for storing the result
        int res = Integer.MAX_VALUE;
        int[] indices = new int[]{0, 0};

        // Sliding window iteration
        while (j < s.length()) {
            // If the current character is in t, update mps and check if it's needed
            char charInS = s.charAt(j);
            if (mpt.containsKey(charInS)) {
                mps.put(charInS, mps.getOrDefault(charInS, 0) + 1);
                if (mps.get(charInS).equals(mpt.get(charInS))) {
                    cur++;
                }
            }

            // Shrink the window
            while (cur == total) {
                // Update result if the current window is smaller
                if (j - i + 1 < res) {
                    res = j - i + 1;
                    indices[0] = i;
                    indices[1] = j;
                }

                // Shrink the window from the left
                char charToRemove = s.charAt(i);
                if (mps.containsKey(charToRemove)) {
                    mps.put(charToRemove, mps.get(charToRemove) - 1);
                    if (mps.get(charToRemove) < mpt.getOrDefault(charToRemove, 0)) {
                        cur--;
                    }
                }
                i++;
            }

            // Expand the window
            j++;
        }

        // Check if a valid result was found
        if (res == Integer.MAX_VALUE) {
            return "";
        }

        // Build the final answer substring
        return s.substring(indices[0], indices[1] + 1);
    }
    }
