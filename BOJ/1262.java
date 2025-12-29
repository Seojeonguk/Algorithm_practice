import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        Problem problem = new Problem();
        problem.init();
        problem.solve();
        problem.printAns();
    }

    public static class Problem {

        private int n;
        private int startRow;
        private int startCol;
        private int endRow;
        private int endCol;

        private char[][] printedRooms;

        public void init() throws IOException {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                n = Integer.parseInt(st.nextToken());
                startRow = Integer.parseInt(st.nextToken());
                startCol = Integer.parseInt(st.nextToken());
                endRow = Integer.parseInt(st.nextToken());
                endCol = Integer.parseInt(st.nextToken());

                printedRooms = new char[endRow - startRow + 1][endCol - startCol + 1];
            }
        }

        public void solve() {
            int startTrueRow = startRow % (2 * n - 1);
            int startTrueCol = startCol % (2 * n - 1);

            for (int i = 0; i < endRow - startRow + 1; i++) {
                for (int j = 0; j < endCol - startCol + 1; j++) {
                    int distance = calDistance((startTrueRow + i) % (2 * n - 1), (startTrueCol + j) % (2 * n - 1));
                    if (distance >= n) {
                        printedRooms[i][j] = '.';
                    } else {
                        printedRooms[i][j] = (char) ((('a' + (distance % 26)) % 'a' + 'a'));
                    }
                }
            }
        }

        public int calDistance(int x, int y) {
            return Math.abs(x - (n - 1)) + Math.abs(y - (n - 1));
        }

        public void printAns() throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
                for (char[] printedRoom : printedRooms) {
                    bw.write(printedRoom);
                    bw.write("\n");
                }
                bw.flush();
            }
        }
    }
}


