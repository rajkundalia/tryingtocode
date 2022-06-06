package interviewbit.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
Example:

Input:
1 2 3
4 5 6
7 8 9
Return the following:
[
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]
 */
public class AntiDiagonals {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(8);
        list3.add(9);

        list.add(list1);
        list.add(list2);
        list.add(list3);

        System.out.println(solveAntiDiagonalsSolution2(list));
    }

    public static ArrayList<ArrayList<Integer>> solveAntiDiagonalsSolution1(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                ArrayList<Integer> arrayList;
                if (map.containsKey(i + j)) {
                    arrayList = map.get(i + j);
                } else {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(A.get(i).get(j));
                map.put(i + j, arrayList);
            }
        }
        for (int key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> solveAntiDiagonalsSolution2(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = A.size();
        int N = (2 * n) - 1;
        for (int i = 0; i < N; i++) {
            ans.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans.get(i + j).add(A.get(i).get(j));
            }
        }

        return ans;
    }
}
