import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MAX_HP = 100;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int musicCnt = Integer.parseInt(st.nextToken());
        int recoveryHP = Integer.parseInt(st.nextToken());

        int[] musicScores = new int[musicCnt + 1];
        st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= musicCnt; idx++) {
            musicScores[idx] = Integer.parseInt(st.nextToken());
        }

        int[] musicHP = new int[musicCnt + 1];
        st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= musicCnt; idx++) {
            musicHP[idx] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[musicCnt + 1][MAX_HP + 1];
        for (int i = 0; i < musicCnt; i++) {
            for (int j = 0; j <= MAX_HP; j++) {
                int nextHP = Math.min(MAX_HP, j + recoveryHP);
                if (nextHP >= musicHP[i + 1]) {
                    dp[i + 1][nextHP - musicHP[i + 1]] = Math.max(dp[i + 1][nextHP - musicHP[i + 1]], dp[i][j] + musicScores[i + 1]);
                }
                dp[i + 1][nextHP] = Math.max(dp[i + 1][nextHP], dp[i][j]);
            }
        }

        int maxScore = 0;
        for (int i = 0; i <= MAX_HP; i++) {
            maxScore = Math.max(maxScore, dp[musicCnt][i]);
        }
        sb.append(maxScore);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
