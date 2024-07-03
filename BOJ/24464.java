import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int days = Integer.parseInt(br.readLine());
            long[][] dp = new long[days + 1][5];
            for (int i = 0; i < 5; i++) {
                dp[1][i] = 1;
            }

            for (int day = 2; day <= days; day++) {
                dp[day][0] = (dp[day - 1][1] + dp[day - 1][2] + dp[day - 1][3] + dp[day - 1][4]) % MOD;
                dp[day][1] = (dp[day - 1][0] + dp[day - 1][3] + dp[day - 1][4]) % MOD;
                dp[day][2] = (dp[day - 1][0] + dp[day - 1][4]) % MOD;
                dp[day][3] = (dp[day - 1][0] + dp[day - 1][1]) % MOD;
                dp[day][4] = (dp[day - 1][0] + dp[day - 1][1] + dp[day - 1][2]) % MOD;
            }

            long sum = 0;
            for (int i = 0; i < 5; i++) {
                sum = (sum + dp[days][i]) % MOD;
            }

            sb.append(sum);

            bw.write(sb.toString());
        }
    }
}
