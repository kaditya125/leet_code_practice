import java.util.HashSet;
import java.util.List;

public class Solution {
    /**
     * Finds the maximum length of a string that can be formed by concatenating
     * a subsequence of arr that has unique characters.
     *
     * @param arr List of strings
     * @return Maximum length of a string formed by unique characters
     */
    public int maxLength(List<String> arr) {
        return maxLengthHelper(arr, 0, "");
    }

    private int maxLengthHelper(List<String> arr, int index, String current) {
        // Sort the characters in the current string
        String sortedString = sortString(current);

        // Check if the sorted string has unique characters
        if (!hasUniqueCharacters(sortedString)) {
            // If not unique, return 0 as this is not a valid subsequence
            return 0;
        }

        int maxLength = current.length();

        // Iterate through the remaining strings in the array
        for (int i = index; i < arr.size(); i++) {
            // Recursively explore concatenating the current string with the next one
            maxLength = Math.max(maxLength, maxLengthHelper(arr, i + 1, current + arr.get(i)));
        }

        return maxLength;
    }

    private String sortString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    private boolean hasUniqueCharacters(String s) {
        HashSet<Character> uniqueCharactersSet = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (!uniqueCharactersSet.add(ch)) {
                return false;
            }
        }
        return true;
    }
}
