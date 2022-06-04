package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Given a collection of intervals, merge all overlapping intervals.

For example:
Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.
 */
public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        System.out.println(solveMergeOverlappingIntervals(
                new ArrayList<>(List.of(new Interval(1, 3), new Interval(2, 6),
                        new Interval(8, 10), new Interval(9, 18)))));
    }

    public static ArrayList<Interval> solveMergeOverlappingIntervals(ArrayList<Interval> intervals) {
        Collections.sort(intervals, (i1, i2) -> {
            int c = i1.start - i2.start;
            if (c != 0) {
                return c;
            }
            return i1.end - i2.end;
        });
        int idx = 0;
        int n = intervals.size();
        ArrayList<Interval> result = new ArrayList<>();
        while (idx < n) {
            Interval currInterval = intervals.get(idx);
            int currEnd = currInterval.end;
            while (idx < n && intervals.get(idx).start <= currEnd) {
                currEnd = Math.max(intervals.get(idx).end, currEnd);
                idx++;
            }
            result.add(new Interval(currInterval.start, currEnd));
        }
        return result;
    }
}
