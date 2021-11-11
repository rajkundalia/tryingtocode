import java.util.ArrayList;
import java.util.List;

public class PrintMazePathWithJumpsWithoutList {
    /*
        https://youtu.be/MHtAA5UE-6Y
     */

    public static void main(String[] args) {
        getMazePathWithJumps(1, 1, 3, 3, "");
    }

    private static void getMazePathWithJumps(int sr, int sc, int dr, int dc, String path) {
        if(sr == dr && sc == dc) {
            System.out.println(path);
        }
        for (int i = 1; i <= dc - sc; i++) {
            getMazePathWithJumps(sr, sc + i, dr, dc, path + "h" + i);
        }

        for (int i = 1; i <= dr - sr; i++) {
            getMazePathWithJumps(sr + i, sc, dr, dc, path + "v" + i);
        }

        for (int i = 1; i <= dc - sc && i <= dr - sr; i++) {
            getMazePathWithJumps(sr + i, sc + i, dr, dc, path + "d" + i);
        }
    }
}
