class Solution {
    public int maximumValue(String[] strs) {
        int maxValue = 0;

        for (String str : strs) {
            int currentValue = 0;

            if (isNumeric(str)) {
                currentValue = Integer.parseInt(str);
            } else {
                currentValue = str.length();
            }

            maxValue = Math.max(currentValue, maxValue);
        }

        return maxValue;
    }

    // Check if the string is numeric
    private boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }
}
