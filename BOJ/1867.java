import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int rockCnt = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] edge = new ArrayList[size];
        for (int idx = 0; idx < size; idx++) {
            edge[idx] = new ArrayList<>();
        }

        for (int rock = 0; rock < rockCnt; rock++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            edge[x].add(y);
        }

        boolean[] isVisit = new boolean[size];
        int[] matched = new int[size];
        Arrays.fill(matched, -1);

        int ans = 0;
        for (int idx = 0; idx < size; idx++) {
            Arrays.fill(isVisit, false);
            if (dfs(edge, idx, isVisit, matched)) {
                ans++;
            }
        }
        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean dfs(ArrayList<Integer>[] edge, int pos, boolean[] isVisit, int[] matched) {
        if (isVisit[pos]) {
            return false;
        }
        isVisit[pos] = true;
        for (int next : edge[pos]) {
            if (matched[next] == -1 || dfs(edge, matched[next], isVisit, matched)) {
                matched[next] = pos;
                return true;
            }
        }
        return false;
    }
}
