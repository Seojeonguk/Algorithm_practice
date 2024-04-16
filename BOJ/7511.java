import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 1; tc <= testCase; tc++) {
                int userCnt = Integer.parseInt(br.readLine());
                int relationshipCnt = Integer.parseInt(br.readLine());

                UnionFind uf = new UnionFind(userCnt);

                for (int relationshipNum = 0; relationshipNum < relationshipCnt; relationshipNum++) {
                    StringTokenizer relationshipInfo = new StringTokenizer(br.readLine());
                    int u = Integer.parseInt(relationshipInfo.nextToken());
                    int v = Integer.parseInt(relationshipInfo.nextToken());

                    uf.union(u, v);
                }

                sb.append(String.format("Scenario %d:", tc)).append("\n");

                int queryCnt = Integer.parseInt(br.readLine());
                for (int queryNum = 0; queryNum < queryCnt; queryNum++) {
                    StringTokenizer queryInfo = new StringTokenizer(br.readLine());
                    int u = Integer.parseInt(queryInfo.nextToken());
                    int v = Integer.parseInt(queryInfo.nextToken());
                    sb.append(uf.isConnected(u, v)).append("\n");
                }

                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }

    static class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int u, int v) {
            u = find(u);
            v = find(v);

            if (u != v) {
                parent[v] = u;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public int isConnected(int u, int v) {
            return find(u) == find(v) ? 1 : 0;
        }
    }
}
