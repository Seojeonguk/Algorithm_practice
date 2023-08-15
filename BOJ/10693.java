import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());

            int computerCnt = Integer.parseInt(st.nextToken());
            int cableCnt = Integer.parseInt(st.nextToken());

            sb.append(String.format("Case %d: %d\n", tc + 1, cableCnt - (computerCnt - 1)));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
