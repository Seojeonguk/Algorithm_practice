import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            String firstStr = br.readLine();
            String secondStr = br.readLine();

            int firstStrLength = firstStr.length();
            int secondStrLength = secondStr.length();

            int[][] dp = new int[firstStrLength + 1][secondStrLength + 1];
            for (int i = 1; i <= firstStrLength; i++) {
                for (int j = 1; j <= secondStrLength; j++) {
                    dp[i][j] = (firstStr.charAt(i - 1) == secondStr.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]));
                }
            }

            sb.append(dp[firstStrLength][secondStrLength]);

            bw.write(sb.toString());
        }
    }
}
