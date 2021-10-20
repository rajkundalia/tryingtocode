import java.util.ArrayList;
import java.util.List;

//https://youtu.be/3fjt19bjs3A

public class GetKeyPadCombination {
    public static void main(String[] args) {
        String str = "123";
        List<String> list = getKPC(str);
        System.out.println(list);
    }

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    private static List<String> getKPC(String str) {
        if(str.length() == 0) {
            List<String> mres = new ArrayList<>();
            mres.add("");
            return mres;
        }
        char ch = str.charAt(0);
        String restOfString = str.substring(1);

        List<String> rres = getKPC(restOfString);
        List<String> mres = new ArrayList<>();

        String codeForCh = codes[ch - '0'];
        for (int i = 0; i < codeForCh.length(); i++) {
            char c = codeForCh.charAt(i);
            for (String st: rres) {
                mres.add(c + st);
            }
        }
        return mres;
    }
}
