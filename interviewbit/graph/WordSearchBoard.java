package interviewbit.graph;

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent"
cells are those horizontally or vertically neighboring. The cell itself does not count as an adjacent cell.

The same letter cell may be used more than once.
Example :
Given board =
[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns 1,
word = "SEE", -> returns 1,
word = "ABCB", -> returns 1,
word = "ABFSAB" -> returns 1
word = "ABCD" -> returns 0
Note that 1 corresponds to true, and 0 corresponds to false.
 */
public class WordSearchBoard {
    public static void main(String[] args) {
        System.out.println(new WordSearchBoard().exist(new String[]{"ABCE", "SFCS", "ADEE"}, "ABCCED"));
    }

    public int exist(String[] A, String B) {
        if (B == "") {
            return 1;
        }

        int row = A.length;

        if (row == 0) {
            return 0;
        }

        int column = A[0].length();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // if first index matches
                if (A[i].charAt(j) == B.charAt(0)) {
                    if (searchDFS(i, j, 0, A, B, row, column)) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    private boolean searchDFS(int x, int y, int index, String[] A, String B, int row, int column) {
        if (index == B.length() - 1) {
            return true;
        }
        index++;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            // inside boundary and matched character
            if (newX >= 0 && newY >= 0 && newX < row && newY < column && A[newX].charAt(newY) == B.charAt(index)) {
                if (searchDFS(newX, newY, index, A, B, row, column)) {
                    return true;
                }
            }
        }
        return false;
    }
}
