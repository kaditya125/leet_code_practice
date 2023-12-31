import java.util.HashMap;

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, Integer> lastOccurrence = new HashMap<>();
        int maxLength = -1;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (lastOccurrence.containsKey(currentChar)) {
                int lastOccurIndex = lastOccurrence.get(currentChar);
                maxLength = Math.max(maxLength, i - lastOccurIndex - 1);
            } else {
                lastOccurrence.put(currentChar, i);
            }
        }

        return maxLength;
    }
}
