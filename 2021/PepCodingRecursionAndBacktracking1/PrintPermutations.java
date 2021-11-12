public class PrintPermutations {
    /*
        https://youtu.be/sPAT_DbvDj0
     */
    public static void main(String[] args) {
        printPermutations("abc", "");
    }

    private static void printPermutations(String ques, String answerSoFar) {
        if(ques.length() == 0) {
            System.out.println(answerSoFar);
            return;
        }
        for (int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            String ls = ques.substring(0, i);
            String rs = ques.substring(i + 1);
            printPermutations(ls + rs, answerSoFar + ch);
        }
    }
}
