package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.

Input Format:
The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.

Output Format:
Return a 2-d matrix that satisfies the given conditions.
Constraints:

1 <= N, M <= 1000
0 <= A[i][j] <= 1
Examples:

Input 1:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 1, 1]   ]

Output 1:
    [   [0, 0, 0],
        [1, 0, 1],
        [1, 0, 1]   ]
=======================
Input 2:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 0, 1]   ]

Output 2:
    [   [0, 0, 0],
        [1, 0, 1],
        [0, 0, 0]   ]
    https://www.geeksforgeeks.org/a-boolean-matrix-question/
 */
public class SetMatrixZeros {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(0);
        list1.add(1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        list2.add(1);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(0);
        list3.add(1);

        list.add(list1);
        list.add(list2);
        list.add(list3);

        //ArrayList<ArrayList<Integer>> dupList = new ArrayList<>(list);
        //solveSetMatrixZerosApproachOne(list);
        //System.out.println(list);
        solveSetMatrixZerosApproachTwo(list);
        System.out.println(list);
    }

    /*
        Approach 1:
        We take 2 lists row and column of length as per the input matrix.
        [1, 0, 1]
        [1, 1, 1]
        [1, 0, 1]
        Here:
        initialization:
        row -> 1,1,1
        col -> 1,1,1

        Now in input, 0 comes at position (0,1), so we transform row and col as:
        row -> 0,1,1
        col -> 1,0,1

        Now in input, second 0 comes at positing (2,1), so we transform row and col as:
        row -> 0,1,0
        col -> 1,0,1

        Using the row and col, traverse through the matrix and fill it with 0s where row or column has 0.
     */
    public static void solveSetMatrixZerosApproachOne(ArrayList<ArrayList<Integer>> a) {
        int r = a.size();
        int c = a.get(0).size();
        List<Integer> row = new ArrayList<>(Collections.nCopies(r, 1));
        List<Integer> col = new ArrayList<>(Collections.nCopies(c, 1));


        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (a.get(i).get(j) == 0) {
                    row.set(i, 0);
                    col.set(j, 0);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (row.get(i) == 0 || col.get(j) == 0) {
                    a.get(i).set(j, 0);
                }
            }
        }
    }

    /*
        Approach 2:
        1) Scan the first row and set a variable rowFlag to indicate whether we need to set all 0s in first row or not.
        2) Scan the first column and set a variable colFlag to indicate whether we need to set all 0s in first
        column or not.
        3) Then we would mark first element in that row as 0, and we would also mark
        beginning of that column/row as 0 and where 0 is found in the matrix.
        e.g.
        [1->0, 0->0, 1]
        [1, 1, 1]
        [1->0, 0->0, 1]
        4) Now we avoid first row and first column and start from row 1 and column 1, and we will check wherever we have
        element at first row and first column as 0, we make other elements as 0 in that row and columns.
        [0, 0, 1]
        [1, 1, 1]
        [0, 0, 1=>0]
        4) Finally, using rowFlag and colFlag, update first row and first column if needed.
     */
    public static void solveSetMatrixZerosApproachTwo(ArrayList<ArrayList<Integer>> a) {
        int r = a.size();
        int c = a.get(0).size();
        boolean fRow = false;
        boolean fCol = false;

        for (int i = 0; i < r; i++) {
            if (a.get(i).get(0) == 0) {
                fCol = true;
            }
        }

        for (int i = 0; i < c; i++) {
            if (a.get(0).get(i) == 0) {
                fRow = true;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (a.get(i).get(j) == 0) {
                    a.get(i).set(0, 0);
                    a.get(0).set(j, 0);
                }
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (a.get(i).get(0) == 0 || a.get(0).get(j) == 0) {
                    a.get(i).set(j, 0);
                }
            }
        }

        if (fRow == true) {
            for (int i = 0; i < c; i++) {
                a.get(0).set(i, 0);
            }
        }

        if (fCol == true) {
            for (int i = 0; i < r; i++) {
                a.get(i).set(0, 0);
            }
        }
    }
}
