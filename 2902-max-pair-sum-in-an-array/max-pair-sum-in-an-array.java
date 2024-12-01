class Solution {
    // Method to find the largest digit in a number
    public int maxDigit(int num) {
        int max = Integer.MIN_VALUE;

        while (num > 0) {
            int digit = num % 10; 
            if (digit > max) {
                max = digit; 
            }
            num /= 10; 
        }

        return max;
    }

   
    public int maxSum(int[] nums) {
        int result = -1;

        Map<Integer, Integer> maxDigitMap = new HashMap<>();

        for (int num : nums) {
            int maxDigit = maxDigit(num);

            if (maxDigitMap.containsKey(maxDigit)) {
                result = Math.max(result, num + maxDigitMap.get(maxDigit));
                maxDigitMap.put(maxDigit, Math.max(num, maxDigitMap.get(maxDigit)));
            } else {
        
                maxDigitMap.put(maxDigit, num);
            }
        }

        return result;
    }
}
