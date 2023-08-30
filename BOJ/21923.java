import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MAX = 10000 * 1000 * 10;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        int[][] scores = new int[rowSize + 2][colSize + 2];
        for (int row = 1; row <= rowSize; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= colSize; col++) {
                scores[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] upScores = new int[rowSize + 2][colSize + 2];
        int[][] downScores = new int[rowSize + 2][colSize + 2];
        for (int row = 0; row < rowSize + 2; row++) {
            for (int col = 0; col < colSize + 2; col++) {
                upScores[row][col] = downScores[row][col] = -MAX;
            }
        }
        for (int row = rowSize; row >= 1; row--) {
            for (int col = 1; col <= colSize; col++) {
                int max = Math.max(upScores[row + 1][col], upScores[row][col - 1]);
                upScores[row][col] = (max == -MAX ? 0 : max) + scores[row][col];
            }
            for (int col = colSize; col >= 1; col--) {
                int max = Math.max(downScores[row + 1][col], downScores[row][col + 1]);
                downScores[row][col] = (max == -MAX ? 0 : max) + scores[row][col];
            }
        }

        int maxScore = -MAX;
        for (int row = 1; row <= rowSize; row++) {
            for (int col = 1; col <= colSize; col++) {
                int score = upScores[row][col] + downScores[row][col];
                maxScore = Math.max(maxScore, score);
            }
        }
        sb.append(maxScore);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
