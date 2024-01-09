import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final long MOD = 1000000007;
    static final int MAX_TREE = 200000;

    public static void main(String[] args) throws Exception {
        int totalTree = Integer.parseInt(br.readLine());

        Seg tree = new Seg(MAX_TREE * 4);
        Seg cnt = new Seg(MAX_TREE * 4);

        long ans = 1;
        for (int i = 0; i < totalTree; i++) {
            int treePlace = Integer.parseInt(br.readLine());
            long treeSum = 0;
            if (i > 0) {
                long left = tree.query(0, treePlace - 1, 0, MAX_TREE - 1, 1);
                long leftCnt = cnt.query(0, treePlace - 1, 0, MAX_TREE - 1, 1);

                long right = tree.query(treePlace + 1, MAX_TREE - 1, 0, MAX_TREE - 1, 1);
                long rightCnt = cnt.query(treePlace + 1, MAX_TREE - 1, 0, MAX_TREE - 1, 1);

                treeSum = (leftCnt * treePlace - left) % MOD;
                treeSum = (treeSum + right - rightCnt * treePlace) % MOD;

                ans = (ans * treeSum) % MOD;
            }

            tree.update(treePlace, treePlace, 0, MAX_TREE - 1, 1);
            cnt.update(treePlace, 1, 0, MAX_TREE - 1, 1);
        }

        sb.append(ans % MOD);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Seg {
        long[] tree;

        Seg(int size) {
            tree = new long[size];
        }

        long query(int l, int r, int nL, int nR, int node) {
            if (l > nR || r < nL) {
                return 0;
            }

            if (l <= nL && nR <= r) {
                return tree[node];
            }

            int mid = (nL + nR) / 2;

            return query(l, r, nL, mid, node * 2) + query(l, r, mid + 1, nR, node * 2 + 1);
        }

        long update(int pos, long value, int l, int r, int node) {
            if (pos < l || r < pos) {
                return tree[node];
            }

            if (l == r) {
                return tree[node] += value;
            }

            int mid = (l + r) / 2;
            return tree[node] = update(pos, value, l, mid, node * 2) + update(pos, value, mid + 1, r, node * 2 + 1);
        }
    }
}
