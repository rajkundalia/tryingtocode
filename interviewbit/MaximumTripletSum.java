package interviewbit;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

//https://youtu.be/l_hPdol4CSU
//Max Triplet Sum | Arrays | GFG | Algorithm Explanation by alGOds
public class MaximumTripletSum {
    public static void main(String[] args) {
        System.out.println(maximumTripletSum(new ArrayList<>(List.of(2, 5, 3, 6, 1, 4, 1))));
    }

    private static int maximumTripletSum(ArrayList<Integer> integers) {
        int n = integers.size();

        int[] maxSuffixArray = new int[n + 1];
        maxSuffixArray[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxSuffixArray[i] = Math.max(maxSuffixArray[i + 1], integers.get(i));
        }

        int ans = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(Integer.MIN_VALUE);

        // n - 1 because last element won't have anything on the right side
        for (int i = 0; i < n - 1; i++) {
            if (maxSuffixArray[i + 1] > integers.get(i)) {
                ans = Math.max(ans, set.lower(integers.get(i)) + integers.get(i) + maxSuffixArray[i + 1]);
                set.add(integers.get(i));
            }
        }

        return ans;
    }
}
