package interviewbit.twopointers;

import java.util.List;

/*
You are given 3 arrays A, B and C. All 3 of the arrays are sorted.
Find i, j, k such that :

max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))
**abs(x) is absolute value of x and is implemented in the following manner : **

      if (x < 0) return -x;
      else return x;
Example :
Input :
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]
Output : 5
         With 10 from A, 15 from B and 10 from C.
 */
public class Array3Pointers {
    public static void main(String[] args) {
        System.out.println(minimize(List.of(1, 4, 10), List.of(2, 15, 20), List.of(10, 12)));
    }

    /*
        max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

        This means that B[j], C[k] and A[i] are maximum on the getting subtracted side.
     */
    public static int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int i = 0;
        int j = 0;
        int k = 0;
        int ans = Integer.MAX_VALUE;

        while (i < A.size() && j < B.size() && k < C.size()) {
            int mini = Math.min(Math.min(A.get(i), B.get(j)), C.get(k));
            int diff = Math.max(Math.max(A.get(i), B.get(j)), C.get(k)) - mini;

            ans = Math.min(ans, diff);

            if (mini == A.get(i)) {
                i++;
            } else if (mini == B.get(j)) {
                j++;
            } else {
                k++;
            }
        }
        return ans;
    }
}
