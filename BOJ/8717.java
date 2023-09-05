import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int tapeCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] tapes = new int[tapeCnt];
        int left = 0, right = 0;
        for (int idx = 0; idx < tapeCnt; idx++) {
            tapes[idx] = Integer.parseInt(st.nextToken());
            right += tapes[idx];
        }

        int minDiff = (int) 1e10;
        for (int idx = 0; idx < tapeCnt - 1; idx++) {
            left += tapes[idx];
            right -= tapes[idx];
            minDiff = Math.min(minDiff, Math.abs(right - left));
        }
        sb.append(minDiff);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
