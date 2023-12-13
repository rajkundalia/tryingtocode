package leetcode.topinterview150;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
return the maximum number of points that lie on the same straight line.



Example 1:


Input: points = [[1,1],[2,2],[3,3]]
Output: 3
Example 2:


Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
 */
public class MaxPointsOnALine {
    public static void main(String[] args) {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(new MaxPointsOnALine().maxPoints(points));
    }

    /*
        Line is represented by y = mx + c
        m is the slope i.e. (y2 - y1)/(x2 - x1)

        y2 = mx2 + c;
        c = y2 - mx2

        m and c can uniquely identify any particular line

        Form a map with slope -> number of points with same slope


     */
    public int maxPoints(int[][] points) {
        if(points.length <= 0) {
            return 0;
        }

        if(points.length <= 2) {
            return points.length;
        }

        int max = 0;

        for(int[] point1: points) {
            Map<Double, Integer> map = new HashMap<>();
            for (int[] point2: points) {
                if(point1 == point2) {
                    continue;
                }

                double slope = 0;

                // if x1 and x2 are equal, then line is vertical
                if(point2[0] == point1[0]) {
                    slope = Double.POSITIVE_INFINITY;
                } else {
                    slope = (point2[1] - point1[1]) / (double) (point2[0] - point1[0]);
                }

                map.put(slope, map.getOrDefault(slope, 0) + 1);
                if(map.get(slope) > max) {
                    max = map.get(slope);
                }
            }
        }
        return max + 1;
    }
}
