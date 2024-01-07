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
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Seg seg = new Seg(n * 4);
        seg.init(arr, 0, n - 1, 1);

        int query = Integer.parseInt(br.readLine());
        while (query-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 1) {
                seg.update(a - 1, b, 0, n - 1, 1);
            } else if (command == 2) {
                Data maxIdx = seg.query(a - 1, b - 1, 0, n - 1, 1);
                Data left = seg.query(a - 1, maxIdx.idx - 1, 0, n - 1, 1);
                Data right = seg.query(maxIdx.idx + 1, b - 1, 0, n - 1, 1);
                sb.append(Math.max(left.x, right.x) + maxIdx.x).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Data {
        int x, idx;

        Data(int x, int idx) {
            this.x = x;
            this.idx = idx;
        }
    }

    static class Seg {
        Data[] tree;

        Seg(int size) {
            tree = new Data[size];
            for (int i = 0; i < size; i++) {
                tree[i] = new Data(0, 0);
            }
        }

        Data init(int[] arr, int l, int r, int node) {
            if (l == r) {
                return tree[node] = new Data(arr[l], l);
            }
            int mid = (l + r) / 2;
            Data left = init(arr, l, mid, node * 2);
            Data right = init(arr, mid + 1, r, node * 2 + 1);

            return tree[node] = (left.x > right.x ? left : right);
        }

        Data query(int l, int r, int nL, int nR, int node) {
            if (nR < l || nL > r) {
                return new Data(-1, -1);
            }
            if (l <= nL && nR <= r) {
                return tree[node];
            }
            int mid = (nL + nR) / 2;

            Data left = query(l, r, nL, mid, node * 2);
            Data right = query(l, r, mid + 1, nR, node * 2 + 1);

            return (left.x > right.x ? left : right);
        }

        Data update(int pos, int value, int l, int r, int node) {
            if (pos < l || r < pos) {
                return tree[node];
            }
            if (l == r) {
                tree[node].x = value;
                tree[node].idx = l;
                return tree[node];
            }

            int mid = (l + r) / 2;
            Data left = update(pos, value, l, mid, node * 2);
            Data right = update(pos, value, mid + 1, r, node * 2 + 1);

            return tree[node] = (left.x > right.x ? left : right);
        }
    }
}
