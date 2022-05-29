package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NobleIntegers {

    public static void main(String[] args) {
        System.out.println(solveNobleIntegers(new ArrayList<>(List.of(-1, -2, 0, 0, 0, -3))));
    }

    static int solveNobleIntegers(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A);
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && A.get(i) == A.get(i + 1)) {
                continue;
            }
            if (A.get(i) == n - i - 1) {
                return 1;
            }
        }
        return -1;
    }

}
