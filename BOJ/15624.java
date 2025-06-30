import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    final static int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int nth = Integer.parseInt(br.readLine());
            sb.append(findNthFib(nth));

            bw.write(sb.toString());
        }
    }

    public static int findNthFib(int n) {
        if (n == 0) {
            return 0;
        }

        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % MOD;
        }

        return fib[n];
    }
}
