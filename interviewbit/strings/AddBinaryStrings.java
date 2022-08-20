package interviewbit.strings;

/*
Given two binary strings, return their sum (also a binary string).
Example:
a = "100"

b = "11"
Return a + b = "111".
 */
public class AddBinaryStrings {
    public static void main(String[] args) {
        System.out.println(addBinary("100", "11"));
    }

    public static String addBinary(String A, String B) {
        int lA = A.length() - 1;
        int lB = B.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (lA >= 0 || lB >= 0) {
            int vA = lA >= 0 ? A.charAt(lA--) - '0' : 0;
            int vB = lB >= 0 ? B.charAt(lB--) - '0' : 0;
            int sum = vA + vB + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }
        return carry == 1 ? sb.insert(0, 1).toString() : sb.toString();
    }
}
