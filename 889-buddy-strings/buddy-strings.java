class Solution {
    public boolean buddyStrings(String s, String goal) {
        // Step 1: Check if lengths are equal
        if (s.length() != goal.length()) {
            return false;
        }

        // Step 2: If strings are equal
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (char ch : s.toCharArray()) {
                count[ch - 'a']++;
                if (count[ch - 'a'] > 1) {
                    return true; // Found a character repeated at least twice
                }
            }
            return false; // No character repeated at least twice
        } else {
            // Find differing indices
            int firstDiff = -1, secondDiff = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (firstDiff == -1) {
                        firstDiff = i;
                    } else if (secondDiff == -1) {
                        secondDiff = i;
                    } else {
                        return false; // More than two differing indices
                    }
                }
            }

            return (secondDiff != -1 && s.charAt(firstDiff) == goal.charAt(secondDiff) &&
                    s.charAt(secondDiff) == goal.charAt(firstDiff));
        }
    }
}
