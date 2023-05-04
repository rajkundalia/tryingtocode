package interviewbit.graph;

/*
Given a binary matrix A of size N x M.

Cells which contain 1 are called filled cell and cell that contain 0 are called empty cell.
Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally.
If one or more filled cells are also connected, they form a region. Find the length of the largest region.

Problem Constraints
 1 <= N, M <= 102
 A[i][j]=0 or A[i][j]=1

Input Format
First argument is a 2D binary matrix Aof size  N x M.

Output Format
Return a single interger denoting the length of largest region.

Example Input
Input 1:
 A = {  {0, 0, 1, 1, 0},
        {1, 0, 1, 1, 0},
        {0, 1, 0, 0, 0},
        {0, 0, 0, 0, 1},
    },
Input 2:
 A = {  {1, 1, 1},
        {0, 0, 1},
    },

Example Output
Output 1:
 6
Output 2:
 4

Example Explanation
Explanation 1:
 The largest region is denoted by red color in the matrix:
    00110
    10110
    01000
    00001
Explanation 2:
 The largest region is:
    111
    001
 */
public class RegionInBinaryMatrix {
    public static void main(String[] args) {
        System.out.println(new RegionInBinaryMatrix().solve(new int[][]{
                {0, 0, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1}
        }));
    }

    int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    int[] dy = {1, 0, -1, 1, 0, -1, 1, -1};

    public int solve(int[][] A) {
        int ans = 0;
        int row = A.length;
        if (row == 0) {
            return 0;
        }
        int column = A[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (A[i][j] == 1) {
                    ans = Math.max(ans, dfs(A, i, j, row, column));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] a, int i, int j, int row, int column) {
        if (i < 0 || j < 0 || i >= row || j >= column || a[i][j] == 0) {
            return 0;
        }

        a[i][j] = 0;
        int ans = 1;

        for (int k = 0; k < 8; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];

            ans += dfs(a, newX, newY, row, column);
        }
        return ans;
    }

}
