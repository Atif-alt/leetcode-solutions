import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;
        int m = intervals[0].length;
        int[][] a = intervals;

        Arrays.sort(a, (x, y) -> x[1] - y[1]);

        int count = 0;
        int end = a[0][1];

        for (int i = 1; i < n; i++) {
            if (a[i][0] < end) {
                count++;
            } else {
                end = a[i][1];
            }
        }

        return count;
    }
}