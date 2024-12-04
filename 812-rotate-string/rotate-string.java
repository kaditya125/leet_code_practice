class Solution {
    public boolean rotateString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        // Concatenate s1 with itself
        String concatenated = s1 + s1;

        // Check if s2 is a substring of concatenated
        return concatenated.indexOf(s2) != -1;
    }
}