import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] nums = br.readLine().toCharArray();
        int[] dp = new int[nums.length + 1];
        dp[0] = dp[1] = 1;
        
        for (int idx = 1; idx < nums.length; idx++) {
            dp[idx + 1] += dp[idx];
            
            int sum = (nums[idx - 1] - '0') * 10 + (nums[idx] - '0');
            if (10 <= sum && sum <= 34) {
                dp[idx + 1] += dp[idx - 1];
            }
            
            if (nums[idx] == '0') {
                dp[idx + 1] -= dp[idx];
            }
        }

        sb.append(dp[nums.length]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
