// import java.util.HashSet;
// import java.util.List;

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
        // Check if the current string has unique characters
        HashSet<Character> uniqueCharactersSet = new HashSet<>();
        for (char ch : current.toCharArray()) {
            if (!uniqueCharactersSet.add(ch)) {
                // If a character is repeated, return 0 as this is not a valid subsequence
                return 0;
            }
        }

        int maxLength = current.length();

        // Iterate through the remaining strings in the array
        for (int i = index; i < arr.size(); i++) {
            // Recursively explore concatenating the current string with the next one
            maxLength = Math.max(maxLength, maxLengthHelper(arr, i + 1, current + arr.get(i)));
        }

        return maxLength;
    }
}
