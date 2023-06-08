package interviewbit.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
Given any source point, (C, D) and destination point, (E, F) on a chess board,
we need to find whether Knight can move to the destination or not.

Knight's movements on a chess board

The above figure details the movements for a knight ( 8 possibilities ).

If yes, then what would be the minimum number of steps for the knight to move to the said point.

If knight can not move from the source point to the destination point, then return -1.

Note: A knight cannot go out of the board.

Input Format:

The first argument of input contains an integer A.
The second argument of input contains an integer B.
    => The chessboard is of size A x B.
The third argument of input contains an integer C.
The fourth argument of input contains an integer D.
    => The Knight is initially at position (C, D).
The fifth argument of input contains an integer E.
The sixth argument of input contains an integer F.
    => The Knight wants to reach position (E, F).
Output Format:

If it is possible to reach the destination point, return the minimum number of moves.
Else return -1.
Constraints:

1 <= A, B <= 500
Example

Input 1:
    A = 8
    B = 8
    C = 1
    D = 1
    E = 8
    F = 8

Output 1:
    6

Explanation 1:
    The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight wants to reach position (8, 8).
    The minimum number of moves required for this is 6.
 */
public class KnightOnChessBoard {
    public static void main(String[] args) {
        System.out.println(new KnightOnChessBoard().knight(8, 8, 1, 1, 8, 8));
    }

    public int knight(int A, int B, int C, int D, int E, int F) {
        // since the index is 1 based
        C--;
        D--;
        E--;
        F--;

        if (C == E && D == F) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        int[][] v = new int[A][B];

        q.add(new Pair(C, D, 0));
        v[C][D] = 1;

        int dirx[] = {1, 2, 2, 1, -1, -2, -2, -1};
        int diry[] = {-2, -1, 1, 2, 2, 1, -1, -2};

        while (!q.isEmpty()) {
            Pair p = q.remove();
            if (p.i == E && p.j == F) {
                return p.s;
            }

            for (int k = 0; k < 8; k++) {
                int x = p.i + dirx[k];
                int y = p.j + diry[k];

                if (x < A && x >= 0 && y < B && y >= 0 && v[x][y] == 0) {
                    q.add(new Pair(x, y, p.s + 1));
                    v[x][y] = 1;
                }
            }
        }
        return -1;
    }
}

class Pair {
    int i;
    int j;
    int s;

    Pair(int i, int j, int s) {
        this.i = i;
        this.j = j;
        this.s = s;
    }
}
