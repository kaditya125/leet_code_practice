class Solution {
    public String largestGoodInteger(String num) {
        String str = "";
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < num.length() - 1; i++) {
            char ch = num.charAt(i);
            char ch1 = num.charAt(i - 1);
            char ch2 = num.charAt(i + 1);

            if (ch == ch1 && ch == ch2) {
                String currentSubstring = num.substring(i - 1, i + 2);
                if (!currentSubstring.isEmpty() && Integer.parseInt(currentSubstring) > max) {
                    max = Integer.parseInt(currentSubstring);
                    str = currentSubstring;
                }
            }
        }
        return str;
    }
}
