package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class PerfectPeakArray {
    public static void main(String[] args) {
        System.out.println(solvePerfectPeakArray(new ArrayList<>(List.of(1, 2, 3, 4, 5, 4, 3, 2, 3, 10))));
    }

    private static int solvePerfectPeakArray(ArrayList<Integer> A) {
        int n = A.size();
        int[] mx = new int[n];
        int[] mn = new int[n];

        mx[0] = A.get(0);
        mn[n - 1] = A.get(n - 1);
        int mxx = A.get(0);
        int mnn = A.get(n - 1);

        for (int i = 1; i < n; i++) {
            mxx = Math.max(mxx, A.get(i));
            mx[i] = mxx;
        }

        for (int i = n - 2; i >= 0; i--) {
            mnn = Math.min(mnn, A.get(i));
            mn[i] = mnn;
        }

        for (int i = 1; i < n - 1; i++) {
            if (A.get(i) > mx[i - 1] && A.get(i) < mn[i + 1]) {
                return 1;
            }
        }
        return 0;
    }
}
