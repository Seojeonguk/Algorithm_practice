import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int MAX_RANGE = 1000000000;

    public static void main(String[] args) throws Exception {
        int lineCnt = Integer.parseInt(br.readLine());
        int left = -MAX_RANGE, right = -MAX_RANGE;
        int totalLength = 0;
        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (right < x) {
                totalLength += right - left;
                left = x;
                right = y;
            } else {
                right = Math.max(right, y);
            }
        }
        sb.append(totalLength + right - left);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
