public class PrintEncodings {
  
    // https://youtu.be/2ClSccwnq1Y
    public static void main(String[] args) {
        printEncodings("123", "");
    }

    private static void printEncodings(String ques, String asf) {
        if (ques.length() == 0) {
            System.out.println(asf);
            return;
        } else if (ques.length() == 1) {
            char ch = ques.charAt(0);
            if (ch == '0') {
                return;
            } else {
                int chn = ch - '0';
                char code = (char) ('a' + chn - 1);
                System.out.println(asf + code);
            }
        } else {
            char ch = ques.charAt(0);
            String roq = ques.substring(1);
            if (ch == '0') {
                return;
            } else {
                int chn = ch - '0';
                char code = (char) ('a' + chn - 1);
                printEncodings(roq, asf + code);
            }
            String ch2 = ques.substring(0, 2);
            String roq2 = ques.substring(2);

            Integer chn2 = Integer.parseInt(ch2);
            if (chn2 <= 26) {
                char code = (char) ('a' + chn2 - 1);
                printEncodings(roq2, asf + code);
            }
        }
    }
}
