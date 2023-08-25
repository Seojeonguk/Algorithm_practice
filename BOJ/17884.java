import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int peopleCnt = Integer.parseInt(br.readLine());
        int[] lineups = new int[peopleCnt];
        lineups[0] = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < peopleCnt - 1; i++) {
            int where = Integer.parseInt(st.nextToken());
            lineups[where + 1] = i + 2;
        }

        for (int i = 0; i < peopleCnt; i++) {
            sb.append(lineups[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
