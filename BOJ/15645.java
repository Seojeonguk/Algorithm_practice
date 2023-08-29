import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] min = new int[2][3];
        int[][] max = new int[2][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            min[i % 2][0] = Math.min(min[(i + 1) % 2][0], min[(i + 1) % 2][1]) + first;
            max[i % 2][0] = Math.max(max[(i + 1) % 2][0], max[(i + 1) % 2][1]) + first;

            int second = Integer.parseInt(st.nextToken());
            min[i % 2][1] = Math.min(min[(i + 1) % 2][0], Math.min(min[(i + 1) % 2][1], min[(i + 1) % 2][2])) + second;
            max[i % 2][1] = Math.max(max[(i + 1) % 2][0], Math.max(max[(i + 1) % 2][1], max[(i + 1) % 2][2])) + second;

            int third = Integer.parseInt(st.nextToken());
            min[i % 2][2] = Math.min(min[(i + 1) % 2][1], min[(i + 1) % 2][2]) + third;
            max[i % 2][2] = Math.max(max[(i + 1) % 2][1], max[(i + 1) % 2][2]) + third;
        }

        sb.append(Math.max(max[(n + 1) % 2][0], Math.max(max[(n + 1) % 2][1], max[(n + 1) % 2][2])))
                .append(" ")
                .append(Math.min(min[(n + 1) % 2][0], Math.min(min[(n + 1) % 2][1], min[(n + 1) % 2][2])));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
