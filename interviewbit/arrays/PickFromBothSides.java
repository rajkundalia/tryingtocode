package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class PickFromBothSides {
    public static void main(String[] args) {

        System.out.println(solve(new ArrayList<>(List.of(5, -2, 3, 1, 2)), 3));
    }

    private static int solve(ArrayList<Integer> integers, int b) {
        int n = integers.size();
        int i = 0, j = n - 1;
        int sum = 0;
        int b2 = b;
        while (b > 0) {
            sum += integers.get(i);
            i++;
            b--;
        }

        int ans = sum;

        while (b2 > 0) {
            i--;
            sum -= integers.get(i);
            sum += integers.get(j);
            j--;
            ans = Math.max(ans, sum);
            b2--;
        }
        return ans;
    }
}
