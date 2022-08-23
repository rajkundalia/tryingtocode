package interviewbit.strings;

/*
Given two numbers represented as strings, return multiplication of the numbers as a string.
Note: The numbers can be arbitrarily large and are non-negative.
Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer.

For example,
given strings "12", "10", your answer should be “120”.
NOTE : DO NOT USE BIG INTEGER LIBRARIES ( WHICH ARE AVAILABLE IN JAVA / PYTHON ).
We will retroactively disqualify such submissions and the submissions will incur penalties.
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("25", "25"));
    }

    public static String multiply(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[] values = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int product = (A.charAt(i) - '0') * (B.charAt(j) - '0');
                int sum = values[i + j + 1] + product; // storing should start from end side or right side or last position
                values[i + j] += sum / 10; // this is for the carry
                values[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int value : values) {
            if (sb.length() != 0 || value != 0) {
                sb.append(value);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
