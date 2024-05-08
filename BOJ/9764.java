import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int MAX = 2000;
    static final int MOD = 100999;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int[] dp = new int[MAX + 1];
            dp[0] = 1;

            for (int i = 1; i <= MAX; i++) {
                for (int j = 2000; j >= i; j--) {
                    dp[j] = (dp[j] + dp[j - i]) % MOD;
                }
            }

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 1; tc <= testCase; tc++) {
                int n = Integer.parseInt(br.readLine());
                sb.append(dp[n]).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
