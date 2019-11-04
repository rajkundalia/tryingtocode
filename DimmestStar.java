import java.util.*;

/*

This is not the CORRECT SOLUTION.
Dimmest Star
Sophia is sitting on the roof of her house on a moonless night looking up at a collection of stars. She mentally marked them with numbers from 1 to n. She picked out the brightest star in the sky and connected them with other stars in decreasing order of brightness.

She’s bewildered with such a large connected network of stars. She wants to know which star is dimmest. Can you help her?

The problem can be seen as a uni-directional non-cyclic graph with n-1 edges.

Example

alt text


Here 5 is the brightest and 1 is the dimmest. You may assume that stars in one “level” of the graph are of the same brightness. That is, in the case above, stars 6 and 2 are of the same brightness level while 3 and 4 are also equally bright.

So the output will be 1.

Note that if there’s more than one dimmest star, the output should be the star with the lowest index.

Input Format
The first line contains ‘t’ which is the no. of test cases.

For each test case, the first line is an integer n which is the number of stars. Then n - 1 lines follows consisting of two space separated integers a b. This represents a directed edge connecting a to b.

The last line is an integer which represents the starting point (the brightest star.)

Output Format
For every test case, print out a single integer which is the index of the dimmest star.

Constraints
0 < t < 200 (number of test cases)

0 < n < 10000 (number of points in the graph)

Sample input
2
7
5 6
5 2
6 4
6 3
4 7
7 1
5
10
7 2
7 3
7 6
7 4
7 10
3 5
6 8
6 1
8 9
7
Sample Output
1
9
Explanation of Sample test case:
There are 2 test cases. The first test case is explained in the example where the result was 1.

In second test case there are 10 points in the graph and 7 is the starting point.

The longest path from 7 is 7->6->8->9. So, 9 is the answer. And just to be clear, in this example, stars 4, 2, 6, 3 and 10 are of the same brightness level. 1, 8 and 5 are all equally bright as well.

Task

For each test case, output an integer which represents the dimmest star in the sky.
 1
8
5
6
5
2
6
4
6
3
4
7
7
1
7
8
5

 */

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Queue;

public class solution {

    public static void main(String[] args) {

        InputReader sc = new InputReader(System.in);
        //PrintWriter pw = new PrintWriter(System.out);
        int T = sc.readInt();
        while (T-- > 0) {
            int n = sc.readInt();
            ArrayList<Integer> arr[] = new ArrayList[n + 1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new ArrayList<>();
            }
            int inEdge[] = new int[n + 1];
            int outEdge[] = new int[n + 1];
            for (int i = 0; i < n - 1; i++) {
                int u = sc.readInt();
                int v = sc.readInt();
                arr[u].add(v);
                outEdge[u]++;
                inEdge[v]++;
            }
            int start = sc.readInt();
            Queue<Integer> q = new ArrayDeque<>();
            ArrayList<Integer> lastLevel = new ArrayList<>();
            ArrayList<Integer> currentLevel = new ArrayList<>();
            q.add(start);
            q.add(-1);
            while (!q.isEmpty()) {
                int parent = q.poll();
                if (parent == -1) {
                    if (!currentLevel.isEmpty()) {
                        lastLevel.clear();
                        lastLevel.addAll(currentLevel);
                        currentLevel.clear();
                        if (!q.isEmpty()) {
                            q.add(-1);
                        }
                    }
                } else {
                    for (Integer i : arr[parent]) {
                        currentLevel.add(i);
                        q.add(i);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i : lastLevel) {
                min = Math.min(min, i);
            }
            System.out.println(min);
        }
    }

    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}

