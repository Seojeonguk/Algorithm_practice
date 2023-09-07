import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int gameCnt = Integer.parseInt(br.readLine());
        int aWin = 0, bWin = 0;
        for (int game = 0; game < gameCnt; game++) {
            st = new StringTokenizer(br.readLine());
            int cowA = Integer.parseInt(st.nextToken());
            int cowB = Integer.parseInt(st.nextToken());

            if (cowA % 3 + 1 == cowB) {
                aWin++;
            }
            if (cowB % 3 + 1 == cowA) {
                bWin++;
            }
        }

        sb.append(Math.max(aWin, bWin));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
