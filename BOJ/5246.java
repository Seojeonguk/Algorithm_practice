import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int cases, pieceCnt;
    static int[] x, y, pieceCntonRows;

    public static void main(String[] args) throws Exception {
        cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            st = new StringTokenizer(br.readLine());
            pieceCnt = Integer.parseInt(st.nextToken());

            x = new int[pieceCnt];
            y = new int[pieceCnt];
            pieceCntonRows = new int[9];

            for (int j = 0; j < pieceCnt; j++) {
                x[j] = Integer.parseInt(st.nextToken());
                y[j] = Integer.parseInt(st.nextToken());
                pieceCntonRows[y[j]]++;
            }
            int maximumCntonRows = 0;
            for (int j = 1; j <= 8; j++) {
                maximumCntonRows = Math.max(maximumCntonRows, pieceCntonRows[j]);
            }
            sb.append(maximumCntonRows).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
