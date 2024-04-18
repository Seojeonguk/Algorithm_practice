import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int MAX_VALUE = 1 << 15;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int[][] dp = new int[MAX_VALUE][5];
            for (int i = 1; i * i < MAX_VALUE; i++) {
                dp[i * i][1] = 1;

                for (int j = i * i; j < MAX_VALUE; j++) {
                    dp[j][2] += dp[j - i * i][1];
                    dp[j][3] += dp[j - i * i][2];
                    dp[j][4] += dp[j - i * i][3];
                }
            }

            while (true) {
                int x = Integer.parseInt(br.readLine());
                if (x == 0) {
                    break;
                }
                
                int sum = 0;
                for (int i = 1; i < 5; i++) {
                    sum += dp[x][i];
                }

                sb.append(sum).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
