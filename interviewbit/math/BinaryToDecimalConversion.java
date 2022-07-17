package interviewbit.math;

public class BinaryToDecimalConversion {
    public static void main(String[] args) {
        System.out.println(solveBinaryToDecimal("1101"));
    }

    public static int solveBinaryToDecimal(String a) {
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == '1')
            result += Math.pow(2, a.length() - 1 - i);
        }
        return result;
    }
}
