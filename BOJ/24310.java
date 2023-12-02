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
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

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

        int firstLength = ranges[0][1] - ranges[0][0] + 1;
        int secondLength = ranges[1][1] - ranges[1][0] + 1;
        int overlapLength = (ranges[1][0] <= ranges[0][1] ? Math.min(ranges[0][1], ranges[1][1]) - Math.max(ranges[0][0], ranges[1][0]) + 1 : 0);

        sb.append(firstLength + secondLength - overlapLength);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
