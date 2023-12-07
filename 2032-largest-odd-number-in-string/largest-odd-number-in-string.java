class Solution {
    public String largestOddNumber(String num) {
        String result = "";
        int n = num.length();
        
        for (int i = n - 1; i >= 0; i--) {
            char ch = num.charAt(i);
            int digit = ch - '0';
            
            if (digit % 2 != 0) {
                result = num.substring(0, i + 1);
                break;
            }
        }
        
        return result;
    }
}
