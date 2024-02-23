import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 1000 * 1000;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int houseCnt = Integer.parseInt(br.readLine());
        int[][] house = new int[houseCnt][3];
        int[][] dp = new int[houseCnt + 1][3];

        for (int i = 0; i < houseCnt; i++) {
            StringTokenizer color = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(color.nextToken());
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][j] = (i == j ? house[0][j] : MAX);
            }

            for (int k = 1; k < houseCnt; k++) {
                dp[k][0] = house[k][0] + Math.min(dp[k - 1][1], dp[k - 1][2]);
                dp[k][1] = house[k][1] + Math.min(dp[k - 1][0], dp[k - 1][2]);
                dp[k][2] = house[k][2] + Math.min(dp[k - 1][0], dp[k - 1][1]);
            }

            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    minCost = Math.min(minCost, dp[houseCnt - 1][j]);
                }
            }
        }

        sb.append(minCost);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
