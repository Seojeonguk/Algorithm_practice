import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int islandCnt = Integer.parseInt(br.readLine());
        int[] group = new int[islandCnt + 1];
        for (int idx = 1; idx <= islandCnt; idx++) {
            group[idx] = idx;
        }
        for (int i = 0; i < islandCnt - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            merge(group, a, b);
        }

        Loop1:
        for (int i = 1; i <= islandCnt; i++) {
            for (int j = i + 1; j <= islandCnt; j++) {
                if (find(group, i) != find(group, j)) {
                    sb.append(i).append(" ").append(j);
                    break Loop1;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int[] group, int x) {
        if (x == group[x]) {
            return x;
        }
        return group[x] = find(group, group[x]);
    }

    public static void merge(int[] group, int a, int b) {
        a = find(group, a);
        b = find(group, b);
        if (a == b) {
            return;
        }
        group[b] = a;
    }
}
