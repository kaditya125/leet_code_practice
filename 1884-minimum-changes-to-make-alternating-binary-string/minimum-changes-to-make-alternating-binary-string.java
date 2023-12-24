class Solution {
    public int minOperations(String s) {
        int operationsToMakeAlternate = 0;

        // Check the expected character based on the index
        for (int i = 0; i < s.length(); i++) {
            char expectedChar = (i % 2 == 0) ? '0' : '1';

            // If the current character is not the expected one, perform an operation
            if (s.charAt(i) != expectedChar) {
                operationsToMakeAlternate++;
            }
        }

        // The minimum number of operations is either operationsToMakeAlternate or s.length() - operationsToMakeAlternate
        // This is because you can also consider changing all characters to the opposite of the expected pattern
        return Math.min(operationsToMakeAlternate, s.length() - operationsToMakeAlternate);
    }
}
