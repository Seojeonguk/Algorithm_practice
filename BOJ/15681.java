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
        int root = Integer.parseInt(st.nextToken());
        int queryCnt = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] lines = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            lines[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            lines[u].add(v);
            lines[v].add(u);
        }

        int[] peakCnt = new int[n + 1];
        boolean[] isVisit = new boolean[n + 1];

        dfs(lines, root, peakCnt, isVisit);

        for (int i = 0; i < queryCnt; i++) {
            int subRoot = Integer.parseInt(br.readLine());
            sb.append(peakCnt[subRoot]).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(ArrayList<Integer>[] lines, int subRoot, int[] peakCnt, boolean[] isVisit) {
        isVisit[subRoot] = true;
        int peaks = 1;
        for (int nextRoot : lines[subRoot]) {
            if (isVisit[nextRoot]) {
                continue;
            }
            peaks += dfs(lines, nextRoot, peakCnt, isVisit);
        }
        return peakCnt[subRoot] = peaks;
    }
}
