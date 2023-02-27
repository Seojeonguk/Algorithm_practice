import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int k, a, b, e;
    static ArrayList<Integer>[] al = new ArrayList[101];
    static int[] parent = new int[101];

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 101; i++) {
            al[i] = new ArrayList<>();
            parent[i] = -1;
        }

        k = Integer.parseInt(br.readLine());

        while ((st = new StringTokenizer(br.readLine())) != null) {
            a = Integer.parseInt(st.nextToken());

            if (a == -1) break;

            while (st.hasMoreTokens()) {
                b = Integer.parseInt(st.nextToken());
                al[b].add(a);
            }
        }

        solve();

        Stack<Integer> ans = new Stack<>();

        while (e != k) {
            ans.add(e);
            e = parent[e];
        }
        ans.add(k);

        while (!ans.isEmpty()) {
            sb.append(ans.pop() + " ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve() {
        Queue<Integer> q = new LinkedList<>();
        parent[k] = 0;
        q.add(k);

        while (!q.isEmpty()) {
            int now = q.poll();

            if (al[now].isEmpty())
                e = now;

            for (int next : al[now]) {
                if (parent[next] != -1) continue;
                parent[next] = now;
                q.add(next);
            }
        }
    }
}
