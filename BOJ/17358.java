import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static final long MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        long n = Long.parseLong(br.readLine());
        long ans = 1;

        while (n > 1) {
            ans = (ans * (n - 1)) % MOD;
            n -= 2;
        }

        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
    }
}
