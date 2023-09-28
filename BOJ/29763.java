import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static long MOD = 1000000007L;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        String x = br.readLine();

        sb.append(solve(n, m, x));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static long solve(long N, long M, String X) {
        if (N == 1) {
            long ret = 0;
            for (int i = 0; i < M; i++) {
                long aa = pow(2, i);
                if (X.charAt(X.length() - i - 1) == '1') {
                    ret = (ret + aa) % MOD;
                }
            }
            return ret;
        }

        long twoPowM = pow(2, M) % MOD;
        long ans = ((twoPowM % MOD) - 1 + MOD) % MOD;
        ans = (ans * modInverse(2L)) % MOD;
        ans = ((ans % MOD) * (N % MOD)) % MOD;

        return ans;
    }

    private static long pow(long base, long exp) {
        long result = 1;
        base = base % MOD;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }

            exp = exp >> 1;
            base = (base * base) % MOD;
        }

        return result;
    }

    private static long modInverse(long a) {
        return pow(a, MOD - 2);
    }
}
