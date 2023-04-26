package interviewbit.graph;

import java.util.LinkedList;

/*
There is a rectangle with the left top as (0, 0) and the right bottom as (x, y).
There are N circles such that their centers are inside the rectangle. The radius of each circle is R.
Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

Note :
We can move from any cell to any of its 8 adjacent neighbors and we cannot move outside the boundary
of the rectangle at any point of time.

A circle doesn't touch a cell (i,j) if the distance from its center to the cell (i,j) is less than R.

Problem Constraints
0 <= x, y, R <= 100
1 <= N <= 1000
The Center of each circle would lie within the grid

Input Format
1st argument given is an Integer x.
2nd argument given is an Integer y.
3rd argument given is an Integer N, the number of circles.
4th argument given is an Integer R, the radius of each circle.
5th argument given is an Array A of size N, where A[i] = x coordinate of the ith circle
6th argument given is an Array B of size N, where B[i] = y coordinate of the ith circle

Output Format
Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).

Example Input
x = 2
y = 3
N = 1
R = 1
A = [2]
B = [3]

Example Output
NO

Example Explanation
There is NO valid path in this case
 */
public class ValidPath {
    public static void main(String[] args) {
        System.out.println(new ValidPath().solve(2, 3, 1, 1, new int[]{2}, new int[]{3}));
    }

    int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};

    public String solve(int x, int y, int N, int R, int[] A, int[] B) {
        return bfs(x, y, N, R, A, B) ? "YES" : "NO";
    }

    private boolean bfs(int fx, int fy, int N, int R, int[] A, int[] B) {
        LinkedList<Integer[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[fx + 1][fy + 1];

        queue.addLast(new Integer[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Integer[] current = queue.removeFirst();
            int x = current[0];
            int y = current[1];

            if (x == fx && y == fy) {
                return true;
            }

            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (inRectangle(newX, newY, fx, fy) && !visited[newX][newY] && !inCircle(newX, newY, R, A, B)) {
                    visited[newX][newY] = true;
                    queue.add(new Integer[]{newX, newY});
                }
            }
        }
        return false;
    }

    private boolean inCircle(int r, int c, int R, int[] A, int[] B) {
        for (int i = 0; i < A.length; i++) {
            int x = A[i];
            int y = B[i];
            if (((r - x) * (r - x) + (c - y) * (c - y)) <= R * R) {
                return true;
            }
        }

        return false;
    }

    private boolean inRectangle(int x, int y, int fx, int fy) {
        return x >= 0 && y >= 0 && x <= fx && y <= fy;
    }
}
