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
            int bushCnt = Integer.parseInt(st.nextToken());

            double[] bushes = new double[bushCnt];
            st = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < bushCnt; idx++) {
                bushes[idx] = Double.parseDouble(st.nextToken());
            }

            for (int idx = 1; idx < bushCnt - 1; idx++) {
                double idxSideAverage = (bushes[idx - 1] + bushes[idx + 1]) / 2.0d;
                bushes[idx] = Math.min(bushes[idx], idxSideAverage);
            }

            sb.append(String.format("Case #%d: %.6f\n", tc + 1, bushes[bushCnt - 2]));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
