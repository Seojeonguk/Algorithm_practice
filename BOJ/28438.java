import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, q, line, value, mod;
    static int[] rows, cols;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        rows = new int[n + 1];
        cols = new int[m + 1];

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            mod = Integer.parseInt(st.nextToken());
            line = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());

            if (mod == 1) {
                rows[line] += value;
            } else if (mod == 2) {
                cols[line] += value;
            }
        }

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= m; col++) {
                sb.append(rows[row] + cols[col]);
                if (col != m) {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
