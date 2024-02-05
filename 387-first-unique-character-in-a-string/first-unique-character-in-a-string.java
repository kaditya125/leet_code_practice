class Solution {
    public int firstUniqChar(String s) {
    
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // Populate the frequencyMap
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Iterate through the string to find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (frequencyMap.get(s.charAt(i)) == 1) {
                return i; // Return the index of the first non-repeating character
            }
        }

        return -1; // If no non-repeating character is found, return -1
    }
}