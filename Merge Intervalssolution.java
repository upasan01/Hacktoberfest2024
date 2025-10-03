import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[][] merge(int[][] intervals) {
        // Check for null or empty input.
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort the intervals based on the start value.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Use a list to store the merged intervals.
        List<int[]> mergedIntervals = new ArrayList<>();

        // Iterate through the sorted intervals.
        int[] currentInterval = intervals[0];
        mergedIntervals.add(currentInterval);

        for (int[] interval : intervals) {
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // Check for overlap
            if (nextStart <= currentEnd) {
                // Merge
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap
                currentInterval = interval;
                mergedIntervals.add(currentInterval);
            }
        }

        // Convert the list to an array
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    // Optional: For local testing only (not required in online judge)
    public static void main(String[] args) {
        Solution merger = new Solution();

        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Merged: " + Arrays.deepToString(merger.merge(intervals1)));
    }
}
