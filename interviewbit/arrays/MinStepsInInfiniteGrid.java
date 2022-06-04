package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class MinStepsInInfiniteGrid {
    public static void main(String[] args) {
        //{4, 6}, {1, 2}, {4, 5}, {10, 12}]
        System.out.println(coverPoints(new ArrayList<>(List.of(4, 1, 4, 10)), new ArrayList<>(List.of(6, 2, 5, 12))));
    }

    public static int coverPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
        int totalDistance = 0;
        int x1 = x.get(0);
        int y1 = y.get(0);
        int n = x.size();
        for (int i = 1; i < n; i++) {
            int x2 = x.get(i);
            int y2 = y.get(i);
            totalDistance += Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
            x1 = x2;
            y1 = y2;
        }
        return totalDistance;
    }
}
