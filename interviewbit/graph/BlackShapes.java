package interviewbit.graph;

/*
Given N x M character matrix A of O's and X's, where O = white, X = black.

Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

Input Format:
    The First and only argument is a N x M character matrix.
Output Format:
    Return a single integer denoting number of black shapes.
Constraints:

    1 <= N,M <= 1000
    A[i][j] = 'X' or 'O'
Example:

Input 1:
    A = [ OOOXOOO
          OOXXOXO
          OXOOOXO  ]
Output 1:
    3
Explanation:
    3 shapes are  :
    (i)    X
         X X
    (ii)
          X
    (iii)
          X
          X
Note: we are looking for connected shapes here.
XXX
XXX
XXX
is just one single connected black shape.
 */
public class BlackShapes {
    public static void main(String[] args) {
        System.out.println(new BlackShapes().black(new String[]{
                "OOOXOOO",
                "OOXXOXO",
                "OXOOOXO"
        }));
    }

    public int black(String[] A) {
        if (A.length == 0) {
            return 0;
        }

        if (A[0].length() == 0) {
            return 0;
        }

        int n = A.length;
        int m = A[0].length();

        char[][] matrix = new char[n][m];

        for (int i = 0; i < n; i++) {
            matrix[i] = A[i].toCharArray();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 'X') {
                    connected(matrix, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void connected(char[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return;
        }

        if (matrix[i][j] != 'X') {
            return;
        }

        matrix[i][j] = 'O';

        connected(matrix, i + 1, j);
        connected(matrix, i - 1, j);
        connected(matrix, i, j + 1);
        connected(matrix, i, j - 1);
    }


}
