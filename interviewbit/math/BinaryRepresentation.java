package interviewbit.math;

public class BinaryRepresentation {
    public static void main(String[] args) {
        System.out.println(convertToBinary(6));
    }

    public static String convertToBinary(int a) {
        if (a == 0) {
            return "0";
        }
        String result = "";
        while (a != 0) {
            int rem = a % 2;
            result = rem + result;
            a /= 2;
        }
        return result;
    }
}
