package interviewbit.twopointers;

import java.util.ArrayList;
import java.util.List;

/*
You are given with an array of 1s and 0s. And you are given with an integer M,
which signifies number of flips allowed.

Find the position of zeros which when flipped will produce maximum continuous series of 1s.
For this problem, return the indices of maximum continuous series of 1s in order.
Example:
Input :
Array = {1 1 0 1 1 0 0 1 1 1 }
M = 1
Output :
[0, 1, 2, 3, 4]
If there are multiple possible solutions, return the sequence which has the minimum start index
 */
public class MaxContinuousSeriesOf1s {
    public static void main(String[] args) {
        System.out.println(maxone(new ArrayList<>(List.of(1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1)), 2));
    }

    public static ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int i = 0;
        int j = 0;
        int ansL = 0;
        int ansR = 0;
        while (j < A.size()) {
            if (A.get(j) == 0) {
                B--;
            }

            while (B < 0) {
                if (A.get(i) == 0) {
                    B++;
                }
                i++;
            }

            if (ansR - ansL < (j - i)) {
                ansR = j;
                ansL = i;
            }
            j++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int k = ansL; k <= ansR; k++) {
            ans.add(k);
        }
        return ans;
    }
}
