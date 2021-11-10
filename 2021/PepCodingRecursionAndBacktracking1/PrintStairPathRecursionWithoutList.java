public class PrintStairPathRecursionWithoutList {
    /*
    https://youtu.be/NEuYcztalew
     */

    public static void main(String[] args) {
        printStairPath(4, "");
    }

    public static void printStairPath(int n, String path) {
        if(n < 0) {
            return;
        }
        if(n == 0) {
            System.out.println(path);
            return;
        }
        printStairPath(n - 1, path + "1");
        printStairPath(n - 2, path + "2");
        printStairPath(n - 3, path + "3");
    }
}
