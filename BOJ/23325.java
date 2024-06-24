import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] arr = br.readLine().toCharArray();

            sb.append(getMaxCal(arr));

            bw.write(sb.toString());
        }
    }

    public static long getMaxCal(char[] arr) {
        long[] dp = new long[arr.length];
        Arrays.fill(dp, Integer.MIN_VALUE);

        dp[0] = (arr[0] == '+' ? 10 : 1);
        if (arr.length == 1) {
            return dp[0];
        }

        dp[1] = (arr[0] == '+' && arr[1] == '-' ? 11 : dp[1]);
        for (int idx = 2; idx < arr.length; idx++) {
            int now = (arr[idx] == '+' ? 10 : 1);

            dp[idx] = (arr[idx - 1] == '+' ? dp[idx - 2] + now : Math.max(dp[idx], dp[idx - 2] - now));

            if (now == 1 && arr[idx - 1] == '+' && idx > 2) {
                dp[idx] = Math.max(dp[idx], dp[idx - 3] + (arr[idx - 2] == '+' ? 11 : -11));
            }
        }

        return dp[arr.length - 1];
    }
}
