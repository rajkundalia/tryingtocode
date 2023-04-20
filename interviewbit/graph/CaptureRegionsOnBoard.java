package interviewbit.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a 2D character matrix A of size N x M, containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Problem Constraints
1 <= N, M <= 103

Input Format
First and only argument 2D character matrix A of size N X M.

Output Format
Make changes to the input only as matrix is passed by reference.

Example Input
Input 1:
 A = [  [X, X, X, X],
        [X, O, O, X],
        [X, X, O, X],
        [X, O, X, X]
     ]

Example Output
Output 1:
 A = [  [X, X, X, X],
        [X, X, X, X],
        [X, X, X, X],
        [X, O, X, X]
     ]

Example Explanation
Explanation 1:
 'O' in (4,2) is not surrounded by X from below.
 */
public class CaptureRegionsOnBoard {

    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        a.add(new ArrayList<>(List.of('X', 'X', 'X', 'X')));
        a.add(new ArrayList<>(List.of('X', 'O', 'O', 'X')));
        a.add(new ArrayList<>(List.of('X', 'X', 'O', 'X')));
        a.add(new ArrayList<>(List.of('X', 'O', 'X', 'X')));
        new CaptureRegionsOnBoard().solve(a);
        System.out.println(a);
    }

    public void solve(ArrayList<ArrayList<Character>> a) {
        int row = a.size();
        if (row == 0) {
            return;
        }

        int column = a.get(0).size();

        // store all boundary O
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (a.get(i).get(j) == 'O' && (i == 0 || j == 0 || i == row - 1 || j == column - 1)) {
                    queue.add(new Pair(i, j));
                    a.get(i).set(j, '^');
                }
            }
        }

        // 4 directions movement
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // multisource BFS using queue
        while (!queue.isEmpty()) {
            int x = queue.peek().first;
            int y = queue.peek().second;
            queue.poll();

            // explore all four directions

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // inside boundary and it is O
                if (newX >= 0 && newY >= 0 && newX < row && newY < column && a.get(newX).get(newY) == 'O') {
                    queue.add(new Pair(newX, newY));
                    a.get(newX).set(newY, '^');
                }
            }
        }

        // change ('O' to 'X') and ('^' to 'O')
        for (ArrayList<Character> characters : a) {
            for (int j = 0; j < column; j++) {
                if (characters.get(j) == '^') {
                    characters.set(j, 'O');
                } else if (characters.get(j) == 'O') {
                    characters.set(j, 'X');
                }
            }
        }
    }
}
