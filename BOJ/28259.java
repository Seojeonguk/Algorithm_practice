import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int heights = Integer.parseInt(st.nextToken());
            int chocolateCnt = Integer.parseInt(st.nextToken());

            boolean[] has = new boolean[n + 1];
            StringTokenizer chocolates = new StringTokenizer(br.readLine());
            for (int i = 0; i < chocolateCnt; i++) {
                int chocolate = Integer.parseInt(chocolates.nextToken());
                has[chocolate] = true;
            }

            long[][] dp = new long[heights + 1][n + 1];
            for (int i = 0; i < n; i++) {
                dp[0][i] = (has[i] ? 0 : 1);
            }

            for (int height = 1; height <= heights; height++) {
                for (int i = 0; i < n; i++) {
                    dp[height][i] = Long.MAX_VALUE;
                    for (int j = 0; j < n; j++) {
                        dp[height][i] = Math.min(dp[height][i], dp[height - 1][j] + dp[height - 1][(i + n - j) % n] + (has[i] ? 0 : 1));
                    }
                }
            }

            long ans = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                ans = Math.min(ans, dp[heights][i]);
            }

            sb.append(ans);

            bw.write(sb.toString());
        }
    }
}
