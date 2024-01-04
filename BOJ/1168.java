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

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int curK = k;

        Seg seg = new Seg(n * 4);
        seg.init(0, n - 1, 1);

        sb.append("<");
        for (int i = 0; i < n; i++) {
            int num = seg.query(curK, 0, n - 1, 1);
            seg.update(num, -1, 0, n - 1, 1);
            sb.append(num + 1);
            if (i < n - 1) {
                curK = (curK + k - 2) % (n - i - 1) + 1;
                sb.append(", ");
            }
        }
        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Seg {
        int[] tree;

        Seg(int size) {
            tree = new int[size];
        }

        int init(int l, int r, int node) {
            if (l == r) {
                return tree[node] = 1;
            }
            int mid = (l + r) / 2;
            int left = init(l, mid, node * 2);
            int right = init(mid + 1, r, node * 2 + 1);

            return tree[node] = left + right;
        }

        int query(int k, int l, int r, int node) {
            if (l == r) {
                return l;
            }
            int mid = (l + r) / 2;

            return (k <= tree[node * 2] ? query(k, l, mid, node * 2) : query(k - tree[node * 2], mid + 1, r, node * 2 + 1));
        }

        int update(int pos, int value, int l, int r, int node) {
            if (pos < l || r < pos) {
                return tree[node];
            }
            if (l == r) {
                return tree[node] += value;
            }

            int mid = (l + r) / 2;
            int left = update(pos, value, l, mid, node * 2);
            int right = update(pos, value, mid + 1, r, node * 2 + 1);

            return tree[node] = left + right;
        }
    }
}
