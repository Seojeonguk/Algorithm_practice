import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int redTileCnt = Integer.parseInt(st.nextToken());
        int brownTileCnt = Integer.parseInt(st.nextToken());

        int n = 1, m = 1;
        Loop1:
        while (true) {
            while (true) {
                if (2 * n + 2 * m - 4 == redTileCnt && (n - 2) * (m - 2) == brownTileCnt) {
                    break Loop1;
                }
                if (2 * n + 2 * m - 4 > redTileCnt || (n - 2) * (m - 2) > brownTileCnt) {
                    break;
                }
                m++;
            }
            n++;
            m = n;
        }
        sb.append(m).append(" ").append(n);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
