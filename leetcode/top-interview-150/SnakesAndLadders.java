package leetcode.topinterview150;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting
from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

You start on square 1 of the board. In each move, starting from square curr, do the following:

Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations,
regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or
ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.

Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of
another snake or ladder, you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the
ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.

Example 1:
Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
Output: 4
Explanation:
In the beginning, you start at square 1 (at row 5, column 0).
You decide to move to square 2 and must take the ladder to square 15.
You then decide to move to square 17 and must take the snake to square 13.
You then decide to move to square 14 and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
This is the lowest possible number of moves to reach the last square, so return 4.
Example 2:
Input: board = [[-1,-1],[-1,3]]
Output: 1
 */
public class SnakesAndLadders {
    public static void main(String[] args) {
        System.out.println(new SnakesAndLadders().snakesAndLadders(new int[][]{{-1, -1}, {-1, 3}}));
    }

    /*
        1. Create a queue and add the starting square to it.
        2. Create a visited array and mark the starting square as visited.
        3. While the queue is not empty:
             - Dequeue the front element from the queue
             - For all possible dice rolls (1 to 6) from the current square:
                 - Calculate the next square by adding the dice roll to the current square
                 - If the next square is out of the board, continue
                 - If the next square has a ladder or snake, update the next square to the corresponding square
                 - If the next square is not visited, mark it as visited and add it to the queue
        4. Return the number of rolls required to reach the final square
     */
    // https://www.nileshblog.tech/leetcode-solving-snakes-and-ladders-with-bfs-algorithm/
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n * n + 1];
        for(int move = 0; !queue.isEmpty(); move++) {
            for(int size = queue.size(); size > 0; size--) {
                int num = queue.poll();
                if(visited[num]) {
                    continue;
                }
                visited[num] = true;
                if(num == n * n) {
                    return move;
                }
                for(int i = 1; i <= 6 && num + i <= n * n; i++) {
                    int next = num + i;
                    int value = getBoardValue(board, next);
                    if(value > 0) {
                        next = value;
                    }
                    if(!visited[next]) {
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    private int getBoardValue(int[][] board, int num) {
        int n = board.length;
        int r = (num - 1)/n;
        int x = n - 1 - r; // find the x coordinate
        int y = r % 2 == 0? num - 1 - r*n: n + r*n - num;
        return board[x][y];
    }
}
