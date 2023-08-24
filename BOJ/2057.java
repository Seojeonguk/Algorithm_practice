import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int MAX_FACTORIAL_IDX = 20;

    public static void main(String[] args) throws Exception {
        long[] factorials = new long[MAX_FACTORIAL_IDX];
        factorials[0] = factorials[1] = 1;
        for (int i = 2; i < MAX_FACTORIAL_IDX; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        long n = Long.parseLong(br.readLine());
        sb.append(isSumOfFactorials(n, factorials));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String isSumOfFactorials(long n, long[] factorials) {
        if (n == 0) {
            return "NO";
        }
        for (int i = MAX_FACTORIAL_IDX - 1; i >= 0; i--) {
            if (n >= factorials[i]) {
                n -= factorials[i];
            }
        }

        return n > 0 ? "NO" : "YES";
    }
}
