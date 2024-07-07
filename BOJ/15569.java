import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 1999;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int ans = getAnswer(n, m);
            sb.append(ans);

            bw.write(sb.toString());
        }
    }

    public static int getAnswer(int n, int m) {
        if (n == 1) {
            return 1;
        }

        int[] ans = new int[Math.max(n, m) + 1];
        ans[1] = 1;
        for (int i = 2; i < n; i++) {
            ans[i] = (ans[i - 1] * 2) % MOD;
        }

        ans[n] = (ans[n - 1] * 4 - 1) % MOD;
        for (int i = n + 1; i <= m; i++) {
            ans[i] = (((ans[n - 1] * 2) % MOD) * ans[i - n]) % MOD;
            for (int j = 1; j <= n - 1; j++) {
                ans[i] = (ans[i] + ans[i - j]) % MOD;
            }
        }

        return ans[m];
    }
}
