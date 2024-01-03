class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         if (intervals.length == 0) {
            return 0;
        }

        // Sort intervals based on their end points
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int nonOverlappingCount = 1;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // Check for overlap
            if (intervals[i][0] >= lastEnd) {
                // Non-overlapping interval found, update lastEnd
                nonOverlappingCount++;
                lastEnd = intervals[i][1];
            }
            // If there is an overlap, skip this interval
        }

        // Calculate the number of intervals to be removed
        int removals = intervals.length - nonOverlappingCount;
        return removals;
    }
}