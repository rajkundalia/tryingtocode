package interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 * <p>
 * Example 2:
 * <p>
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * Make sure the returned intervals are also sorted.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        System.out.println(solveMergeIntervals(new ArrayList<>(List.of(new Interval(1, 3), new Interval(6, 9))),
                new Interval(2, 5)));
    }

    public static ArrayList<Interval> solveMergeIntervals(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans = new ArrayList<>();
        int n = intervals.size();
        int start = newInterval.start;
        int end = newInterval.end;
        boolean check = false;
        for (int i = 0; i < n; i++) {
            // case where interval is smaller and out of range from newInterval
            if (intervals.get(i).end < start) {
                ans.add(intervals.get(i));
            }
            // case where interval is larger and out of range from newInterval
            else if (intervals.get(i).start > end) {
                if (!check) {
                    // this is to make sure that newInterval gets added and sorting order is maintained before larger
                    // interval is added
                    ans.add(new Interval(start, end));
                }
                ans.add(intervals.get(i));
                check = true;
            } else {
                // this scenario when there is clear overlap as a whole either of the interval or newInterval
                //Example 2 can be debugged for that
                start = Math.min(start, intervals.get(i).start);
                end = Math.max(end, intervals.get(i).end);
            }
        }
        // just in case that second condition never fulfils and start and end keep expanding
        if (!check) {
            ans.add(new Interval(start, end));
        }
        return ans;
    }
}

class Interval {
    int start;
    int end;

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
