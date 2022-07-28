package interviewbit.math;

public class LastDigitKCount {
    public static void main(String[] args) {
        System.out.println(solveLastDigitKCount(11, 121, 1));
    }

    // Take example of 34 and 55 and debug
    public static int solveLastDigitKCount(int A, int B, int C) {
        while (A <= B && A % 10 != C) A++;
        if (A > B) {
            return 0;
        }
        return (B - A) / 10 + 1;
    }
}
