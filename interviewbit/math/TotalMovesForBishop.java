package interviewbit.math;

public class TotalMovesForBishop {
    public static void main(String[] args) {
        System.out.println(solveTotalMovesForBishop(4, 4));
    }

    /*
        Explanation: 8X8
        Input: 4X4
        The maximum ends it can reach is:
        1,1
        7,1
        1,7
        8,8

        Based on this, from anywhere, we can calculate distance like:
        min(abs(1-A), abs(1-B)) +
        min(abs(8-A), abs(1-B)) +
        min(abs(1-A), abs(8-B)) +
        min(abs(8-A), abs(8-B))

     */
    public static int solveTotalMovesForBishop(int A, int B) {
        return Math.min(Math.abs(1-A), Math.abs(1-B)) +
                Math.min(Math.abs(8-A), Math.abs(1-B)) +
                Math.min(Math.abs(1-A), Math.abs(8-B)) +
                Math.min(Math.abs(8-A), Math.abs(8-B));
    }
}
