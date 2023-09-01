import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MAX = 56;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long[] powOneCnt = new long[MAX + 1];
        powOneCnt[1] = 1;
        for (int i = 2; i <= MAX; i++) {
            powOneCnt[i] = 2 * powOneCnt[i - 1] + (1L << (i - 1));
        }
        long oneCnt = getOneCnt(powOneCnt, b) - getOneCnt(powOneCnt, a - 1);
        sb.append(oneCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long getOneCnt(long[] powOneCnt, long x) {
        long oneCnt = 0;
        long tempX = x;

        for (int i = MAX; i >= 0; i--) {
            long pow = 1L << i;
            if ((tempX & pow) == 0) {
                continue;
            }
            oneCnt += powOneCnt[i] + (tempX - pow + 1);
            tempX -= pow;
        }
        return oneCnt;
    }
}
