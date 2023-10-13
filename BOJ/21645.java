import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int gameCnt = Integer.parseInt(st.nextToken());
        int maxLevel = Integer.parseInt(st.nextToken());
        int redBadgeLevel = Integer.parseInt(st.nextToken());

        int maxBadgeCnt = Math.min(maxLevel / redBadgeLevel + redBadgeLevel - 1, maxLevel);

        sb.append(gameCnt * maxBadgeCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
