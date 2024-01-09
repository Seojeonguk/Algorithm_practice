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
        int arrSize = Integer.parseInt(br.readLine());
        long[] arr = new long[arrSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrSize; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Seg seg = new Seg(arrSize * 4);
        seg.init(arr, 0, arrSize - 1, 1);

        int query = Integer.parseInt(br.readLine());
        while (query-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                long k = Long.parseLong(st.nextToken());
                seg.rangeUpdate(l - 1, r - 1, 0, arrSize - 1, 1, k);
            } else if (command == 2) {
                int x = Integer.parseInt(st.nextToken());
                long value = seg.query(x - 1, x - 1, 0, arrSize - 1, 1);
                sb.append(value).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Seg {
        long[] tree;
        long[] lazy;

        Seg(int size) {
            tree = new long[size];
            lazy = new long[size];
        }

        long init(long[] arr, int l, int r, int node) {
            if (l == r) {
                return tree[node] = arr[l];
            }
            int mid = (l + r) / 2;
            return tree[node] = init(arr, l, mid, node * 2) + init(arr, mid + 1, r, node * 2 + 1);
        }

        long query(int l, int r, int nL, int nR, int node) {
            lazyUpdate(nL, nR, node);
            if (nR < l || nL > r) {
                return 0;
            }
            if (l <= nL && nR <= r) {
                return tree[node];
            }
            int mid = (nL + nR) / 2;
            return query(l, r, nL, mid, node * 2) + query(l, r, mid + 1, nR, node * 2 + 1);
        }

        long rangeUpdate(int l, int r, int nL, int nR, int node, long diff) {
            lazyUpdate(nL, nR, node);
            if (nR < l || nL > r) {
                return 0;
            }
            if (l <= nL && nR <= r) {
                tree[node] += (nR - nL + 1) * diff;
                if (nL != nR) {
                    lazy[node * 2] += diff;
                    lazy[node * 2 + 1] += diff;
                }
                return tree[node];
            }
            int mid = (nL + nR) / 2;
            return tree[node] = rangeUpdate(l, r, nL, mid, node * 2, diff) + rangeUpdate(l, r, mid + 1, nR, node * 2 + 1, diff);
        }

        void lazyUpdate(int l, int r, int node) {
            if (lazy[node] != 0) {
                tree[node] += (l - r + 1) * lazy[node];
                if (l != r) {
                    lazy[node * 2] += lazy[node];
                    lazy[node * 2 + 1] += lazy[node];
                }
                lazy[node] = 0;
            }
        }
    }
}
