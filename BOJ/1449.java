import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int leakCnt = Integer.parseInt(st.nextToken());
        int tapeLength = Integer.parseInt(st.nextToken());

        int[] leaks = new int[leakCnt];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < leakCnt; idx++) {
            leaks[idx] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(leaks);

        int tapeCnt = 0;
        int tapeStartIdx = -9999;
        for (int idx = 0; idx < leakCnt; idx++) {
            if (tapeStartIdx + tapeLength - 1 < leaks[idx]) {
                tapeStartIdx = leaks[idx];
                tapeCnt++;
            }
        }
        sb.append(tapeCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
