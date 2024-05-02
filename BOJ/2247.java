import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int MOD = 1000000;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            int ans = 0;
            for (int i = 2; i < n; i++) {
                ans = (ans + (n / i - 1) * i) % MOD;
            }

            sb.append(ans);

            bw.write(sb.toString());
        }
    }
}
