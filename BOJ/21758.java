import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int placeCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] honeys = new int[placeCnt];
        int[] accumulateHoney = new int[placeCnt];
        for (int idx = 0; idx < placeCnt; idx++) {
            honeys[idx] = Integer.parseInt(st.nextToken());
            accumulateHoney[idx] = honeys[idx] + (idx > 0 ? accumulateHoney[idx - 1] : 0);
        }

        int maxHoney = 0;
        for (int idx = 1; idx < placeCnt - 1; idx++) {
            maxHoney = Math.max(maxHoney, accumulateHoney[placeCnt - 1] - honeys[0] - honeys[idx] + accumulateHoney[placeCnt - 1] - accumulateHoney[idx]);
            maxHoney = Math.max(maxHoney, accumulateHoney[placeCnt - 1] - honeys[placeCnt - 1] - honeys[idx] + accumulateHoney[idx - 1]);
            maxHoney = Math.max(maxHoney, accumulateHoney[idx] - honeys[0] + accumulateHoney[placeCnt - 1] - accumulateHoney[idx - 1] - honeys[placeCnt - 1]);
        }

        sb.append(maxHoney);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
