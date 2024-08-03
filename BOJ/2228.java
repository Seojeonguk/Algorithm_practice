import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MIN = -32767 * 101;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrLength = Integer.parseInt(st.nextToken());
            int targetRange = Integer.parseInt(st.nextToken());

            int[] arr = new int[arrLength];
            for (int i = 0; i < arrLength; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            int[][] prefixSums = new int[arrLength][arrLength];
            for (int i = 0; i < arrLength; i++) {
                int sum = 0;
                for (int j = i; j < arrLength; j++) {
                    sum += arr[j];
                    prefixSums[i][j] = sum;
                }
            }


            int[][] dp = new int[arrLength + 1][targetRange + 1];
            for (int i = 0; i < arrLength; i++) {
                Arrays.fill(dp[i], -1);
            }

            sb.append(solve(arrLength, targetRange, dp, prefixSums, 0, 0));

            bw.write(sb.toString());
        }
    }

    public static int solve(int arrLength, int targetRange, int[][] dp, int[][] prefixSums, int idx, int curRange) {
        if (targetRange == curRange) {
            return 0;
        }

        if (idx >= arrLength) {
            return MIN;
        }

        if (dp[idx][curRange] != -1) {
            return dp[idx][curRange];
        }

        dp[idx][curRange] = solve(arrLength, targetRange, dp, prefixSums, idx + 1, curRange);
        for (int i = idx; i < arrLength; i++) {
            dp[idx][curRange] = Math.max(dp[idx][curRange], solve(arrLength, targetRange, dp, prefixSums, i + 2, curRange + 1) + prefixSums[idx][i]);
        }

        return dp[idx][curRange];
    }
}
