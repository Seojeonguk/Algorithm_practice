import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        Problem problem = new Problem();
        problem.init();
        problem.solve();
        problem.printAns();
    }

    public static class Problem {

        private int matrixSize;
        private int[][] matrix;
        private int[][] dp;

        private int recursiveCnt;
        private int recursiveDpCnt;

        public void init() throws IOException {
            matrixSize = Integer.parseInt(br.readLine());

            matrix = new int[matrixSize + 1][matrixSize + 1];
            dp = new int[matrixSize + 1][matrixSize + 1];

            for (int row = 1; row <= matrixSize; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int col = 1; col <= matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(st.nextToken());
                }
            }
        }

        public void solve() throws IOException {
            matrixPath(matrixSize, matrixSize);
            matrixPathDp();
        }

        public int matrixPath(int row, int col) {

            if (row == 0 || col == 0) {
                recursiveCnt++;
                return 0;
            }

            return matrix[row][col] + Math.max(matrixPath(row - 1, col), matrixPath(row, col - 1));
        }

        public int matrixPathDp() {
            for (int i = 0; i <= matrixSize; i++) {
                dp[i][0] = dp[0][i] = 0;
            }

            for (int i = 1; i <= matrixSize; i++) {
                for (int j = 1; j <= matrixSize; j++) {
                    dp[i][j] = matrix[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
                    recursiveDpCnt++;
                }
            }

            return dp[matrixSize][matrixSize];
        }

        public void printAns() throws IOException {
            bw.write(String.format("%d %d\n", recursiveCnt, recursiveDpCnt));
            bw.flush();
        }
    }
}
