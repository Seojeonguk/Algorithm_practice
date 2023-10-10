import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int studentCnt = Integer.parseInt(st.nextToken());
        int groupCnt = Integer.parseInt(st.nextToken());
        int[] stats = new int[studentCnt];

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < studentCnt; idx++) {
            stats[idx] = Integer.parseInt(st.nextToken());
        }

        int maxStat = 0;
        for (int bit = 19; bit >= 0; bit--) {
            int cnt = 0;
            maxStat |= (1 << bit);
            for (int idx = 0; idx < studentCnt; idx++) {
                if ((stats[idx] & maxStat) == maxStat) {
                    cnt++;
                }
            }
            if (cnt < groupCnt) {
                maxStat -= (1 << bit);
            }
        }
        sb.append(maxStat);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
