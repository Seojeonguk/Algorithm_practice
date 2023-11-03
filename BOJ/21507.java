import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int TRIANGLE_CNT = 4;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long[] triangles = new long[TRIANGLE_CNT];
        for (int triangle = 0; triangle < TRIANGLE_CNT; triangle++) {
            triangles[triangle] = Long.parseLong(st.nextToken());
        }
        long squareCnt = Math.min(triangles[0], triangles[1]) + Math.min(triangles[2], triangles[3]);

        long sqrt = 1;

        while (sqrt * sqrt <= squareCnt) {
            sqrt++;
        }

        sb.append(sqrt - 1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
