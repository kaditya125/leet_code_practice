class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i += 2 * k) {
            // Get the substring to reverse
            int end = Math.min(i + k, s.length());
            StringBuilder part = new StringBuilder(s.substring(i, end));
            result.append(part.reverse());

            // Append the next k characters without reversing
            if (end < s.length()) {
                int nextEnd = Math.min(i + 2 * k, s.length());
                result.append(s, end, nextEnd);
            }
        }

        return result.toString();
    }
}