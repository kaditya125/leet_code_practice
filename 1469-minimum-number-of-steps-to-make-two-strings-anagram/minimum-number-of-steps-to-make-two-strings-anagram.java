class Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26]; // Array to store character counts

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
        }

        int steps = 0;

        for (int i = 0; i < 26; i++) {
            steps += Math.max(0, count[i]); // Consider only characters in excess in t
        }

        return steps;
    }
}