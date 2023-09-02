import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int logCnt = Integer.parseInt(st.nextToken());
        int queryCnt = Integer.parseInt(st.nextToken());
        int[] group = new int[logCnt + 1];
        for (int idx = 1; idx <= logCnt; idx++) {
            group[idx] = idx;
        }

        Log[] logs = new Log[logCnt];
        for (int idx = 0; idx < logCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            logs[idx] = new Log(idx + 1, startX, endX, y);
        }

        Arrays.sort(logs, (o1, o2) -> {
            if (o1.startX == o2.startX) {
                return Integer.compare(o1.endX, o2.endX);
            }
            return Integer.compare(o1.startX, o2.startX);
        });

        int endX = logs[0].endX;
        for (int idx = 1; idx < logCnt; idx++) {
            if (logs[idx].startX > endX) {
                endX = logs[idx].endX;
            } else {
                merge(group, logs[idx - 1].num, logs[idx].num);
                endX = Math.max(endX, logs[idx].endX);
            }
        }

        for (int i = 0; i < queryCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int logNumA = Integer.parseInt(st.nextToken());
            int logNumB = Integer.parseInt(st.nextToken());

            sb.append(find(group, logNumA) == find(group, logNumB) ? 1 : 0).append("\n");
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

    public static void merge(int[] p, int x, int y) {
        x = find(p, x);
        y = find(p, y);
        p[x] = y;
    }

    static class Log {
        int num;
        int startX;
        int endX;
        int y;

        Log(int num, int startX, int endX, int y) {
            this.num = num;
            this.startX = startX;
            this.endX = endX;
            this.y = y;
        }
    }
}
