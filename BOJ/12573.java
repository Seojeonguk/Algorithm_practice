import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            long atLeastCnt = Long.parseLong(st.nextToken());
            long predictionCnt = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            long temp = atLeastCnt;
            int cnt = -1, ans = 0;
            while (temp < predictionCnt) {
                temp *= c;
                cnt++;
            }
            while (cnt > 0) {
                cnt /= 2;
                ans++;
            }
            sb.append(String.format("Case #%d: %d\n", tc + 1, ans));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
