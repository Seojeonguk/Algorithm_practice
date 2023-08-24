import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        Map<Long, Long> dp = new HashMap<>();
        dp.put(0L, 1L);
        long an = solve(dp, n, p, q, x, y);
        sb.append(an);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static Long solve(Map<Long, Long> dp, long n, long p, long q, long x, long y) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        if (n <= 0) {
            return 1L;
        }
        long left = solve(dp, n / p - x, p, q, x, y);
        long right = solve(dp, n / q - y, p, q, x, y);
        dp.put(n, left + right);

        return left + right;
    }
}
