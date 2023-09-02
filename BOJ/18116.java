import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MAX_ROBOT = 1000000;

    public static void main(String[] args) throws Exception {
        int[] robotParts = new int[MAX_ROBOT + 1];
        int[] robotPartsCnt = new int[MAX_ROBOT + 1];
        for (int i = 1; i <= MAX_ROBOT; i++) {
            robotParts[i] = i;
            robotPartsCnt[i] = 1;
        }
        int orderCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < orderCnt; i++) {
            st = new StringTokenizer(br.readLine());
            char mode = st.nextToken().charAt(0);
            if (mode == 'I') {
                int partA = Integer.parseInt(st.nextToken());
                int partB = Integer.parseInt(st.nextToken());
                merge(robotPartsCnt, robotParts, partA, partB);
            } else {
                int robotNum = Integer.parseInt(st.nextToken());
                int groupNum = find(robotParts, robotNum);
                sb.append(robotPartsCnt[groupNum]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int[] p, int x) {
        if (p[x] == x) {
            return x;
        }
        return p[x] = find(p, p[x]);
    }

    public static void merge(int[] cnt, int[] p, int x, int y) {
        x = find(p, x);
        y = find(p, y);

        if (x == y) {
            return;
        }

        p[Math.min(x, y)] = Math.max(x, y);
        cnt[Math.max(x, y)] += cnt[Math.min(x, y)];
        cnt[Math.min(x, y)] = 0;
    }
}
