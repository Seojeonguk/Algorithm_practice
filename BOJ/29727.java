import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        long n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long sx = Long.parseLong(st.nextToken());
        long sy = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long dx = Long.parseLong(st.nextToken());
        long dy = Long.parseLong(st.nextToken());

        long totalSquare = (n * (n + 1) / 2) * (n * (n + 1) / 2);
        if ((sx == dx || sy == dy) && (Math.abs(sx - dx) > 1 || Math.abs(sy - dy) > 1)) {
            if (sx > dx) {
                long temp = sx;
                sx = dx;
                dx = temp;
            }
            if (sy > dy) {
                long temp = sy;
                sy = dy;
                dy = temp;
            }
            long s = (sx == dx ? Math.max(0, Math.min(n, sy + 1)) : Math.max(0, Math.min(n, sx + 1)));
            long d = (sx == dx ? Math.min(n, Math.max(0, dy)) : Math.min(n, Math.max(0, dx)));

            long total2 = (n + 1) * ((d - s + 1) * (d - s) / 2);
            totalSquare += total2;
        }
        sb.append(totalSquare);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
