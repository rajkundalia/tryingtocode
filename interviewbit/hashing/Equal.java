package interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
Given an array A of integers, find the index of values that satisfy A + B = C + D,
where A,B,C & D are integers values in the array

Note:
1) Return the indices `A1 B1 C1 D1`, so that
  A[A1] + A[B1] = A[C1] + A[D1]
  A1 < B1, C1 < D1
  A1 < C1, B1 != D1, B1 != C1

2) If there are more than one solutions,
   then return the tuple of values which are lexicographical smallest.

Assume we have two solutions
S1 : A1 B1 C1 D1 ( these are values of indices int the array )
S2 : A2 B2 C2 D2

S1 is lexicographically smaller than S2 iff
  A1 < A2 OR
  A1 = A2 AND B1 < B2 OR
  A1 = A2 AND B1 = B2 AND C1 < C2 OR
  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
Example:

Input: [3, 4, 7, 1, 2, 9, 8]
Output: [0, 2, 3, 5] (O index)
If no solution is possible, return an empty list.
 */
public class Equal {
    public static void main(String[] args) {
        System.out.println(equal(new ArrayList<>(List.of(3, 4, 7, 1, 2, 9, 8))));
    }

    // Basically we are checking by adding 2 and subtracting 1 from them and then checking in the set
    // if that remaining value is present or not
    public static ArrayList<Integer> equal(ArrayList<Integer> a) {
        int len = a.size();
        ArrayList<Integer> res = new ArrayList<>(4);
        HashSet<Integer> hs = new HashSet<>(a);
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = i + 1; k < len - 1; k++) {
                    if (j == k)
                        continue;
                    int x = a.get(i) + a.get(j) - a.get(k);
                    if (hs.contains(x)) {
                        int y;
                        for (int m = k + 1; m < len; m++)
                            if (a.get(m) == x && m != j) {
                                res.add(i);
                                res.add(j);
                                res.add(k);
                                res.add(m);
                                return res;
                            }
                    }
                }
            }
        }
        return res;
    }
}