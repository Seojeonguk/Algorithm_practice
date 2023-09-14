import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 4; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] = Math.max(dp[j], dp[i - 3] * (j - i + 2));
            }
        }
        sb.append(dp[n]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
