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

    static final int MAX_VALUE = 65536;

    public static void main(String[] args) throws Exception {
        Seg seg = new Seg(MAX_VALUE * 4);
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (i < range) {
                seg.update(arr[i], 1, 0, MAX_VALUE, 1);
            }
        }

        long sumMid = getMid(seg, range);
        for (int i = 0; i < size - range; i++) {
            seg.update(arr[i], -1, 0, MAX_VALUE, 1);
            seg.update(arr[i + range], 1, 0, MAX_VALUE, 1);
            sumMid += getMid(seg, range);
        }

        sb.append(sumMid);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getMid(Seg seg, int range) {
        int idx = (range + 1) / 2;
        int l = 0, r = seg.tree.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            int sum = seg.query(0, mid, 0, MAX_VALUE, 1);
            if (sum < idx) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    static class Seg {
        int[] tree;

        Seg(int size) {
            tree = new int[size];
        }

        int init(int[] arr, int l, int r, int node) {
            if (l == r) {
                return tree[node] = arr[l];
            }
            int mid = (l + r) / 2;
            return tree[node] = init(arr, l, mid, node * 2) + init(arr, mid + 1, r, node * 2 + 1);
        }

        int update(int pos, int value, int nL, int nR, int node) {
            if (pos < nL || nR < pos) {
                return tree[node];
            }
            if (nL == nR) {
                return tree[node] += value;
            }
            int mid = (nL + nR) / 2;
            return tree[node] = update(pos, value, nL, mid, node * 2) + update(pos, value, mid + 1, nR, node * 2 + 1);
        }

        int query(int l, int r, int nL, int nR, int node) {
            if (nR < l || nL > r) {
                return 0;
            }
            if (l <= nL && nR <= r) {
                return tree[node];
            }
            int mid = (nL + nR) / 2;

            return query(l, r, nL, mid, node * 2) + query(l, r, mid + 1, nR, node * 2 + 1);
        }
    }
}
