import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int limit = Integer.parseInt(br.readLine());

        int KCnt = 0;

        for (int i = 1; i <= n; i++) {
            int now = i;
            int maxFactor = 1;
            for (int j = 2; j * j <= i; j++) {
                while (now % j == 0) {
                    maxFactor = Math.max(maxFactor, j);
                    now /= j;
                }
            }
            if (now != 1) {
                maxFactor = Math.max(maxFactor, now);
            }
            if (maxFactor <= limit) {
                KCnt++;
            }
        }
        sb.append(KCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
