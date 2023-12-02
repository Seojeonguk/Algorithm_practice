import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int l1 = Integer.parseInt(st.nextToken());
        int r1 = Integer.parseInt(st.nextToken());
        int l2 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        sb.append(getCommunicationTime(l1, r1, l2, r2, k));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getCommunicationTime(int a, int b, int c, int d, int k) {
        int[][] ranges = new int[2][2];
        if (Math.min(a, b) <= Math.min(c, d)) {
            ranges[0][0] = Math.min(a, b);
            ranges[0][1] = Math.max(a, b);
            ranges[1][0] = Math.min(c, d);
            ranges[1][1] = Math.max(c, d);
        } else {
            ranges[0][0] = Math.min(c, d);
            ranges[0][1] = Math.max(c, d);
            ranges[1][0] = Math.min(a, b);
            ranges[1][1] = Math.max(a, b);
        }

        int maxStart = Math.max(ranges[0][0], ranges[1][0]);
        int minEnd = Math.min(ranges[0][1], ranges[1][1]);

        int overlapLength = (ranges[1][0] <= ranges[0][1] ? minEnd - maxStart + 1 : 0);
        if (maxStart <= k && k <= minEnd) {
            overlapLength--;
        }

        return overlapLength;
    }
}
