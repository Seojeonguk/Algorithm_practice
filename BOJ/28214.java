import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int bundleCnt = Integer.parseInt(st.nextToken());
        int breadInBundleCnt = Integer.parseInt(st.nextToken());
        int maxNotCreamCnt = Integer.parseInt(st.nextToken());

        int possibleSellBundleCnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int bundle = 0; bundle < bundleCnt; bundle++) {
            int creamCnt = 0;
            for (int bread = 0; bread < breadInBundleCnt; bread++) {
                int isCream = Integer.parseInt(st.nextToken());
                creamCnt += 1 - isCream;
            }
            if (creamCnt < maxNotCreamCnt) {
                possibleSellBundleCnt++;
            }
        }

        sb.append(possibleSellBundleCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
