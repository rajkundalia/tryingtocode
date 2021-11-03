import java.util.List;

public class GetKeyPadCombinationWithoutList {
    public static void main(String[] args) {
        String str = "123";
        getKPC(str, "");
    }

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    private static void getKPC(String str, String answer) {
        if(str.length() == 0) {
            System.out.println(answer);
            return;
        }
        char ch = str.charAt(0);
        String restOfString = str.substring(1);

        String chars = codes[ch - '0'];
        for (int i = 0; i < chars.length(); i++) {
            char cho = chars.charAt(i);
            getKPC(restOfString, answer + cho);
        }
    }
}
/*
adg, adh, adi, aeg, aeh, aei, afg, afh, afi,
bdg, bdh, bdi, beg, beh, bei, bfg, bfh, bfi,
cdg, cdh, cdi, ceg, ceh, cei, cfg, cfh, cfi
*/
