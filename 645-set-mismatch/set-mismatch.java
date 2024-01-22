import java.util.HashSet;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        int sum = n * (n + 1) / 2; // Sum of first n natural numbers

        for (int num : nums) {
            if (set.contains(num)) {
                // Found the duplicate
                result[0] = num;
            }
            set.add(num);
            sum -= num; // Calculate the sum of remaining numbers
        }

        // The missing number is the sum plus the duplicate
        result[1] = result[0] + sum;

        return result;
    }
}
