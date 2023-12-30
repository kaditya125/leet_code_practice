class Solution {
    public int maxPower(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int max = 1;  // Start from 1 because the minimum power is 1 for a non-empty string
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            char ch1 = s.charAt(i - 1);
            char ch2 = s.charAt(i);

            if (ch1 == ch2) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;  // Reset count for a new character
            }
        }

        // Check the last sequence
        max = Math.max(max, count);

        return max;
    }
}
