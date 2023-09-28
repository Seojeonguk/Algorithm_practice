import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            sb.append(solve(n, l)).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int n, int l) {
        if (l > 5) {
            return 0;
        }
        int ret = 0;
        int[][] dp = new int[l + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 2; i <= l; i++) {
            for (int j = 0; j <= n; j++) {
                int kRange = (int) Math.ceil(Math.sqrt(j));
                for (int k = 0; k < kRange; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        return dp[l][n];
    }
}
