class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Calculate left boundaries
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Calculate right boundaries
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int result = 0;

        // Calculate the sum of minimums for each subarray
        for (int i = 0; i < n; i++) {
            long contribution = (long) arr[i] * (i - left[i]) * (right[i] - i) % MOD;
            result = (int) ((result + contribution) % MOD);
        }

        return result;
    }
}