import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken());
            start[x]++;
            if (y < n - 1) {
                end[y]++;
            }
        }

        int[] haystackCnt = new int[n];
        int prefixHaystack = 0;
        for (int i = 0; i < n; i++) {
            prefixHaystack += start[i] - end[i];
            haystackCnt[i] = prefixHaystack;
        }

        Arrays.sort(haystackCnt);
        sb.append(haystackCnt[n / 2]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
