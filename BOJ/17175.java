import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (n > 0) {
            dp[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1] + 1) % MOD;
        }
        sb.append(dp[n]);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
