import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int lineCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int internalCnt = 0, boundaryCnt = 0;
        while (lineCnt-- > 0) {
            int bananaPosition = Integer.parseInt(br.readLine());
            if (x - r == bananaPosition || x + r == bananaPosition) {
                boundaryCnt++;
            } else if (x - r < bananaPosition && bananaPosition < x + r) {
                internalCnt++;
            }
        }
        sb.append(internalCnt).append(" ").append(boundaryCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
