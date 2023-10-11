import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int treeCnt = Integer.parseInt(br.readLine());

        int maxLemon = 0;
        st = new StringTokenizer(br.readLine());
        for (int tree = 1; tree <= treeCnt; tree++) {
            int lemon = Integer.parseInt(st.nextToken());
            maxLemon = Math.max(maxLemon, lemon - (treeCnt + 1 - tree));
        }
        sb.append(maxLemon);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
