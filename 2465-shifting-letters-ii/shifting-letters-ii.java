class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftArray = new int[n + 1]; // Using an array to record cumulative shifts
        
        // Apply the shifts
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            
            if (direction == 1) {
                shiftArray[start] += 1;
                shiftArray[end + 1] -= 1;
            } else {
                shiftArray[start] -= 1;
                shiftArray[end + 1] += 1;
            }
        }
        
        // Compute the prefix sum of the shift array
        int[] cumulativeShifts = new int[n];
        int cumulative = 0;
        for (int i = 0; i < n; i++) {
            cumulative += shiftArray[i];
            cumulativeShifts[i] = cumulative;
        }
        
        // Apply the cumulative shifts to the string
        char[] result = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int shift = cumulativeShifts[i];
            int newChar = ((result[i] - 'a') + shift) % 26;
            if (newChar < 0) {
                newChar += 26; // Handle negative shifts
            }
            result[i] = (char) ('a' + newChar);
        }
        
        return new String(result); 
    }
}