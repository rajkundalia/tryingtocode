package interviewbit.hashing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given an array A of integers and another non negative integer k,
find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example :
Input :
A : [1 5 3]
k : 2
Output :
1
as 3 - 1 = 2

Return 0 / 1 for this problem.
 */
public class DiffkII {
    public static void main(String[] args) {
        System.out.println(diffPossible(List.of(1, 3, 2), 0));
    }

    public static int diffPossible(final List<Integer> A, int B) {
        if (A.size() <= 1) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.size(); i++) {
            if (set.contains(A.get(i) + B) || set.contains(A.get(i) - B)) {
                return 1;
            }
            set.add(A.get(i));
        }
        return 0;
    }
}

//    HashMap<Integer, Integer> map = new HashMap<>();
//
//    int n = A.size();
//        for (int i = 0; i < n; i++) {
//        if (map.containsKey(A.get(i)+B) || map.containsKey(A.get(i)-B)) {
//        return 1;
//        }
//        map.put(A.get(i), i);
//        }
//        return 0;