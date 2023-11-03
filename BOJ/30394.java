import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int dotCnt = Integer.parseInt(br.readLine());
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;

        while (dotCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }

        sb.append(Math.abs(maxY - minY));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
