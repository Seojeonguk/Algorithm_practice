import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        Problem problem = new Problem();
        problem.init();
        problem.solve();
        problem.printAns();
    }

    public static class Problem {
        private final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        private int rowSize;
        private int colSize;
        private int targetDistance;
        private char[][] map;
        private boolean[][] isVisit;

        private int possibilityCnt;

        public Problem() {
            possibilityCnt = 0;
        }

        public void init() throws IOException {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                this.rowSize = Integer.parseInt(st.nextToken());
                this.colSize = Integer.parseInt(st.nextToken());
                this.targetDistance = Integer.parseInt(st.nextToken());

                this.isVisit = new boolean[this.rowSize][this.colSize];
                this.map = new char[this.rowSize][this.colSize];

                for (int row = 0; row < rowSize; row++) {
                    map[row] = br.readLine().toCharArray();

                    Arrays.fill(isVisit[row], false);
                }


            }
        }

        public void solve() {
            isVisit[rowSize - 1][0] = true;
            calPossibility(rowSize - 1, 0, 1);
        }

        public void calPossibility(int x, int y, int distance) {
            if (isTargetDistance(distance)) {
                if (isArrived(x, y)) {
                    this.possibilityCnt++;
                }

                return;
            }

            for (int[] direction : DIRECTIONS) {
                int nextX = x + direction[0];
                int nextY = y + direction[1];

                if (isInvalidPlace(nextX, nextY)) {
                    continue;
                }

                isVisit[nextX][nextY] = true;
                calPossibility(nextX, nextY, distance + 1);
                isVisit[nextX][nextY] = false;
            }
        }

        public boolean isInvalidPlace(int x, int y) {
            return (x < 0 || y < 0 || x >= this.rowSize || y >= this.colSize || this.isVisit[x][y] || this.map[x][y] == 'T');
        }

        public boolean isTargetDistance(int distance) {
            return distance == targetDistance;
        }

        public boolean isArrived(int x, int y) {
            return (x == 0 && y == this.colSize - 1);
        }

        public void printAns() throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
                bw.write(String.valueOf(possibilityCnt));
                bw.flush();
            }
        }
    }
}


