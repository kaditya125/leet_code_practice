class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));

        int n = events.length;
        int[] maxValues = new int[n];
        int maxSum = 0;
        int maxSoFar = 0;

        // Build a prefix max array
        for (int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, events[i][2]);
            maxValues[i] = maxSoFar;
        }

        for (int i = 0; i < n; i++) {
            int start = events[i][0];
            int value = events[i][2];

            // Find the last event that ends before this event starts
            int idx = binarySearch(events, start);
            if (idx != -1) {
                // Include the maximum value from earlier events
                maxSum = Math.max(maxSum, value + maxValues[idx]);
            } else {
                // Take only the current event's value
                maxSum = Math.max(maxSum, value);
            }
        }

        return maxSum; 
    }
     private int binarySearch(int[][] events, int startTime) {
        int left = 0, right = events.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][1] < startTime) {
                result = mid; // Update result to the current mid
                left = mid + 1; // Search on the right half
            } else {
                right = mid - 1; // Search on the left half
            }
        }

        return result;
    }
}