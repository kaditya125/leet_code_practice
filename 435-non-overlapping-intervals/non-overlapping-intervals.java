class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         if (intervals.length == 0) {
            return 0;
        }

        
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int nonOverlappingCount = 1;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= lastEnd) {
                
                nonOverlappingCount++;
                lastEnd = intervals[i][1];
            }
            
        }

       
        int removals = intervals.length - nonOverlappingCount;
        return removals;
    }
}