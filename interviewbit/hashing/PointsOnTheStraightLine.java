package interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given N points on a 2D plane, find the maximum number of points that lie on the same straight line.
You will be given 2 arrays A and B. Each point is represented by (A[i], B[i])

Problem Constraints
1 <= |A| <= 500
|A| == |B|
-109 <= Ai, Bi <= 109


Input Format
The first argument is an integer array A.
The second argument is an integer array B.

Output Format
Return an integer.

Example Input
A = [1, 2]
B = [1, 2]

Example Output
2

Example Explanation
The points on the 2D plane are (1, 1) and (2, 2). A line with the slope (m = 1) passes through both the points.
 */
public class PointsOnTheStraightLine {
    public static void main(String[] args) {
        System.out.println(maxPoints(new ArrayList<>(List.of(4, 8, -4)), new ArrayList<>(List.of(-4, -4, -4))));
    }

    private static HashMap<Double, Integer> hashMap;

    /*
    We can simply find the slope for each pair of points.
    We can then increment the count of the slope.
    The answer would be the slope having maximum count.
    For storing counts we can use a Map.
     */
    public static int maxPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        hashMap = new HashMap<>();
        if (A == null || B == null) {
            return -1;
        }
        if (A.size() == 0) {
            return 0;
        }
        int n = A.size();
        int x1, y1, x2, y2;
        int val;
        int max = 0;

        for (int i = 0; i < n; i++) {
            x1 = A.get(i);
            y1 = B.get(i);
            hashMap.clear();

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                x2 = A.get(j);
                y2 = B.get(j);

                double slope = y2 - y1;
                int den = x2 - x1;

                if (den == 0) {
                    slope = Double.POSITIVE_INFINITY;
                } else {
                    slope = slope / den;
                }

                val = 1;
                if (hashMap.containsKey(slope)) {
                    val = hashMap.get(slope) + 1;
                }
                hashMap.put(slope, val);
            }

            for (Map.Entry<Double, Integer> entry : hashMap.entrySet()) {
                val = entry.getValue();
                max = Math.max(max, val);
            }
        }
        return max + 1;
    }
}
