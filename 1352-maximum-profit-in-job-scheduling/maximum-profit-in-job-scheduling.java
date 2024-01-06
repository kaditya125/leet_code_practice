class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] ans = new int[n][3];

        // Create a 2D array 'ans' to store the start time, end time, and profit for each job
        for (int i = 0; i < n; i++) {
            ans[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        // TreeMap to store the maximum profit at each end time
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);  // Initialize the TreeMap with an entry for time 0 and profit 0

        // Sort the jobs based on their end times in ascending order
        Arrays.sort(ans, (a, b) -> a[1] - b[1]);

        // Iterate through each job and update the maximum profit at its end time
        for (int[] arr : ans) {
            int val = arr[2] + map.floorEntry(arr[0]).getValue();
            if (val > map.lastEntry().getValue()) {
                map.put(arr[1], val);
            }
        }

        // Return the maximum profit at the end time of the last job
        return map.lastEntry().getValue();
    }
}
