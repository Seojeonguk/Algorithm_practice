import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int pointCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] parent = new int[pointCnt + 1];
        for (int i = 2; i <= pointCnt; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long[] scores = new long[pointCnt];
        for (int idx = 0; idx < pointCnt; idx++) {
            scores[idx] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(scores);
        long ans = 0;
        for (int idx = pointCnt - 1; idx >= 0; idx--) {
            ans += scores[idx];
            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
