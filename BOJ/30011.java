import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int polygonCnt = Integer.parseInt(br.readLine());
        int maxScore = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < polygonCnt; i++) {
            int polygon = Integer.parseInt(st.nextToken());
            maxScore += (i == 0 ? 180 * (polygon - 2) : 180 * polygon);
        }
        sb.append(maxScore);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
