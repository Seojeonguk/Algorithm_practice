import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static long MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int initDay = Integer.parseInt(st.nextToken());
        int constant = Integer.parseInt(st.nextToken());
        int kDay = Integer.parseInt(st.nextToken());

        long[] bankBookMoney = new long[initDay];
        long[] diff = new long[initDay + 1];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < initDay; idx++) {
            bankBookMoney[idx] = Long.parseLong(st.nextToken());
            if (idx > 0) {
                diff[idx] = bankBookMoney[idx] - bankBookMoney[idx - 1];
            }
        }

        long constantPow = constant, Dp = 0;
        for (int idx = 1; idx < initDay; idx++) {
            Dp += -constantPow * diff[initDay - idx];
            Dp = (Dp >= 0 ? 1 : -1) * Math.abs(Dp) % MOD;
            constantPow = (constantPow * constant) % MOD;
        }
        diff[initDay] = Dp;

        long ans = Math.abs(diff[(kDay - 1) % initDay + 1]);
        int repetition = (kDay - 1) / initDay;
        while (repetition-- > 0) {
            ans = (ans * constantPow) % MOD;
        }
        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
