class Solution {
      public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        
        while (i < str1.length() && j < str2.length()) {
            char currentChar = str1.charAt(i);
            char targetChar = str2.charAt(j);
            
            if (currentChar == targetChar) {
                j++; 
            } 
           
            else if (nextChar(currentChar) == targetChar) {
                j++; 
            }
            i++; 
        }
        
        return j == str2.length();
    }

    private char nextChar(char c) {
        return (char) ((c - 'a' + 1) % 26 + 'a');
    }
}