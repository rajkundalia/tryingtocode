package interviewbit.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
You are given a AB character matrix named C. Every cell in C has a character U,R,L or D indicating up,right,left and down.

Your target is to go from top left corner to the bottom right corner of the matrix.

But there are some restrictions while moving along the matrix:

If you follow what is written in the cell then you can move freely.
But if you don't follow what is written in the cell then you have to pay 1 unit of cost.
Like: If a cell contains character U and you go right instead of Up you have to pay 1 unit of cost.

So your task is to find the minimum cost to go from top-left corner to the bottom-right corner.

Problem Constraints
1 <= A,B <= 103
C[i][j] can be either U,R,L or D.

Input Format
First Argument represents a integer A (number of rows).
Second Argument represents a integer B (number of columns).
Third Argument represents a string array C which contains A strings each of length B.

Output Format
 Return an integer denoting the minimum cost to travel from top-left corner to bottom-right corner.

Example Input
Input:1
 A = 3
 B = 3
 C = ["RRR","DDD","UUU"]
Input:2
 A = 1
 B = 4
 C = ["LLLL"]

Example Output
Output-1 :
 1
Output-2 :
 3

Example Explanation*
Explanation for Input-1:
 Matrix looks like: RRR
                    DDD
                    UUU
 We go right two times and down two times.
 So from top-right cell we are going down though right is given so this incurs a cost of 1.
Explanation for Input-2:
 Matrix looks like: LLLL
 We go right three times.
 */
public class MinCostPath {
    public static void main(String[] args) {
        System.out.println(new MinCostPath().solve(3, 3, new String[]{"RRR", "DDD", "UUU"}));
    }

    public int solve(int R, int C, String[] grid) {
        boolean[][] visited = new boolean[R][];
        for (int i = 0; i < R; i++) {
            visited[i] = new boolean[C];
        }
        Queue<PointCost> q = new PriorityQueue<>();
        q.offer(new PointCost(0, 0, 0));

        while (!q.isEmpty()) {
            PointCost curr = q.poll();
            if (curr.r < 0 || curr.r >= R || curr.c < 0 || curr.c >= C) {
                continue;
            }
            if (visited[curr.r][curr.c]) {
                continue;
            }
            int r = curr.r;
            int c = curr.c;
            if (r == R - 1 && c == C - 1) {
                return curr.cost;
            }
            visited[curr.r][curr.c] = true;
            char currCh = grid[r].charAt(c);

            q.offer(new PointCost(r + 1, c, curr.cost + (currCh == 'D' ? 0 : 1)));
            q.offer(new PointCost(r - 1, c, curr.cost + (currCh == 'U' ? 0 : 1)));
            q.offer(new PointCost(r, c - 1, curr.cost + (currCh == 'L' ? 0 : 1)));
            q.offer(new PointCost(r, c + 1, curr.cost + (currCh == 'R' ? 0 : 1)));
        }
        return -1;
    }

    private static class PointCost implements Comparable<PointCost> {
        int r;
        int c;
        int cost;

        PointCost(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        public int compareTo(PointCost that) {
            return Integer.compare(this.cost, that.cost);
        }
    }
}
