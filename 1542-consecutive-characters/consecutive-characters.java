class Solution {
    public int maxPower(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int max = 1;
        int left = 0;

        for (int right = 1; right < s.length(); right++) {
            char ch1 = s.charAt(right - 1);
            char ch2 = s.charAt(right);

            if (ch1 == ch2) {
                max = Math.max(max, right - left + 1);
            } else {
                left = right;
            }
        }

        return max;
    }
}
