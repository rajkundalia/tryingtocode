
import java.util.ArrayList;
import java.util.List;

public class GetMazePathWithJumps {
    //https://youtu.be/VaGBRiSdtFI
    public static void main(String[] args) {
        List<String> paths = getMazePathWithJumps(1, 1, 3, 3);
        System.out.println(paths);
    }

    private static List<String> getMazePathWithJumps(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc) {
            List<String> path = new ArrayList<>();
            path.add("");
            return path;
        }
        List<String> paths = new ArrayList<>();

        for (int i = 1; i <= dc - sc; i++) {
            List<String> hPaths = getMazePathWithJumps(sr, sc + i, dr, dc);
            for(String hPath: hPaths) {
                paths.add("h" + i + hPath);
            }
        }

        for (int i = 1; i <= dr - sr; i++) {
            List<String> vPaths = getMazePathWithJumps(sr + i, sc, dr, dc);
            for(String vPath: vPaths) {
                paths.add("v" + i + vPath);
            }
        }

        for (int i = 1; i <= dr - sr && i <= dc - sc; i++) {
            List<String> dPaths = getMazePathWithJumps(sr + i, sc + i, dr, dc);
            for(String dPath: dPaths) {
                paths.add("d" + i + dPath);
            }
        }
        System.out.println(paths.size());
        return paths;
    }
}
