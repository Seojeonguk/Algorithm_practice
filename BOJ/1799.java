import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        boolean[][] isVisit = new boolean[n * 2][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                chess[i][j] = Integer.parseInt(row.nextToken());
            }
        }

        int a = calMaxPuttingQueen(chess, n, isVisit, 0, 0);
        int b = calMaxPuttingQueen(chess, n, isVisit, 1, 1);
        sb.append(a + b);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calMaxPuttingQueen(int[][] chess, int n, boolean[][] isVisit, int idx, int color) {
        if (idx >= n * n) {
            return 0;
        }

        int nextIdx = idx + 2;
        if (n % 2 == 0 && (idx / n != (idx + 2) / n)) {
            nextIdx += (idx + 2) % n == 1 ? -1 : 1;
        }
        int maxQueen = calMaxPuttingQueen(chess, n, isVisit, nextIdx, color);
        int row = idx / n;
        int col = idx % n;

        if (chess[row][col] == 1 && !isVisit[row + col][0] && !isVisit[row - col + n - 1][1]) {
            isVisit[row + col][0] = isVisit[row - col + n - 1][1] = true;
            maxQueen = Math.max(maxQueen, calMaxPuttingQueen(chess, n, isVisit, nextIdx, color) + 1);
            isVisit[row + col][0] = isVisit[row - col + n - 1][1] = false;
        }

        return maxQueen;
    }
}
