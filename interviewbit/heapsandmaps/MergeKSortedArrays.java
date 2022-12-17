package interviewbit.heapsandmaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
You are given K sorted integer arrays in a form of 2D integer matrix A of size K X N.
You need to merge them into a single array and return it.

Problem Constraints
1 <= K, N <= 103
0 <= A[i][j] <= 108
A[i][j] <= A[i][j+1]

Input Format
First and only argument is an 2D integer matrix A.

Output Format
Return a integer array denoting the merged array you get after merging all the arrays in A.

Example Input
Input 1:
 A = [  [1, 2, 3]
        [2, 4, 6]
        [0, 9, 10]
     ]
Example Output
Output 1:
 [0, 1, 2, 2, 3, 4, 6, 9, 10]

Example Explanation
Explanation 1:
 You need to merge [1, 2, 3] , [2, 4, 6] and [0, 9, 10]  into a single array
 so the merged array will look like [0, 1, 2, 2, 3, 4, 6, 9, 10]
 */
public class MergeKSortedArrays {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(new ArrayList<>(List.of(1, 2, 3)),
                new ArrayList<>(List.of(2, 4, 6)), new ArrayList<>(List.of(0, 9, 10))))));
    }

    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
//        ArrayList<Integer> res = new ArrayList<>();
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (ArrayList al : A) {
//            pq.addAll(al);
//        }
//        while (pq.size() != 0) {
//            res.add(pq.poll());
//        }
//        return res;
        //https://stackoverflow.com/a/27806421/10120165
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));
        pq.addAll(A);
        ArrayList<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            ArrayList<Integer> current = pq.poll();
            list.add(current.get(0));
            if (current.size() > 1) {
                pq.add(new ArrayList<>(current.subList(1, current.size())));
            }
        }
        return list;
    }
}
