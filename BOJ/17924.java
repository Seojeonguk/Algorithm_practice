import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int boiledCnt = Integer.parseInt(br.readLine());

        int maxA = -1;
        int minB = 1000;
        for (int boiled = 0; boiled < boiledCnt; boiled++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            maxA = Math.max(maxA, a);
            minB = Math.min(minB, b);
        }
        if (maxA <= minB) {
            sb.append("gunilla has a point");
        } else {
            sb.append("edward is right");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
