package leetcode.topinterview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Example 1:

Input: intervals = {{1,3},{6,9}}, newInterval = {2,5}
Output: {{1,5},{6,9}}
Example 2:

Input: intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}}, newInterval = {4,8}
Output: {{1,2},{3,10},{12,16}}
Explanation: Because the new interval {4,8} overlaps with {3,5},{6,7},{8,10}.

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
 */
public class InsertInterval {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new InsertInterval()
                .insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
    }

    /* Cases for overlap:
        1. a and b do not overlap i.e. 1, 2 and 3, 5
        2. a and b overlap, b ends after a i.e. 1, 5 and 3, 6
        3. a completely overlaps b i.e. 1, 5 and 2, 3
        4. a and b overlap, a ends after b i.e. 3, 6 and 1, 4
        5. b completely overlaps a i.e. 2, 3 and 1, 6
        6. b and a do not overlap i.e. 3, 5 and 1, 2
     */

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            if (intervals[i][1] < newInterval[0]) {
                // current interval starts first & not covered by newInterval, add intervals[i] to ans
                // [curInterval]
                //                      [newInterval]
                ans.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                // newInterval starts first and not covered by current interval
                // add newInterval to ans and set newInterval = curInterval
                //                       [curInterval]
                // [newInterval]
                ans.add(newInterval);
                newInterval = intervals[i];
            } else if (intervals[i][1] >= newInterval[0] || intervals[i][0] <= newInterval[1]) {
                // either of the if condition can work here
                // they are overlapped, merge them
                // [curInterval]
                //        [newInterval]
                // or
                // [newInterval]
                //        [curInterval]
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        // add the last interval
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}
