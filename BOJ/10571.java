import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                int diamondCnt = Integer.parseInt(br.readLine());

                double[][] diamonds = new double[diamondCnt][2];
                for (int i = 0; i < diamondCnt; i++) {
                    StringTokenizer diamondToken = new StringTokenizer(br.readLine());
                    diamonds[i][0] = Double.parseDouble(diamondToken.nextToken());
                    diamonds[i][1] = Double.parseDouble(diamondToken.nextToken());
                }

                sb.append(longestLength(diamonds)).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int longestLength(double[][] diamonds) {
        int[] dp = new int[diamonds.length];
        dp[0] = 1;

        for (int i = 1; i < diamonds.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (diamonds[j][0] < diamonds[i][0] && diamonds[j][1] > diamonds[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
