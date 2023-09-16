import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int rideCnt = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[] minRideHeights = new int[rideCnt];
        st = new StringTokenizer(br.readLine());

        int enjoyingRideCnt = 0;
        for (int ride = 0; ride < rideCnt; ride++) {
            minRideHeights[ride] = Integer.parseInt(st.nextToken());
            if (minRideHeights[ride] <= height) {
                enjoyingRideCnt++;
            }
        }
        sb.append(enjoyingRideCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
