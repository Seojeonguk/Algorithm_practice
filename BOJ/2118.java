import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] cost = new int[n];
        long ans = 0;
        int left = 0;


        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(br.readLine());
            left += cost[i];
        }

        int idx = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            left -= cost[i];
            right += cost[i];

            ans = Math.max(ans, Math.min(left, right));

            while (left <= right && idx <= i) {
                left += cost[idx];
                right -= cost[idx];

                ans = Math.max(ans, Math.min(left, right));

                idx += 1;
            }
        }

        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
    }
}
