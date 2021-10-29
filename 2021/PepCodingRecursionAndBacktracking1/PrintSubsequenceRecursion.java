public class PrintSubsequenceRecursion {
    //https://youtu.be/Ke8TPhHdHMw
    public static void main(String[] args) {
        printSubsequence("abc", "");
    }

    private static void printSubsequence(String question, String ans) {
        if(question.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = question.charAt(0);
        String ros = question.substring(1);
        printSubsequence(ros, ans + ch);
        printSubsequence(ros, ans + "");
    }
}
