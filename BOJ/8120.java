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
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Seg seg = new Seg(size * 4);
        seg.init(0, size - 1, 1);

        int[] ans = new int[size];
        boolean isNotPermutation = false;
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] > i) {
                isNotPermutation = true;
                break;
            }
            ans[i] = seg.query(arr[i], 0, size - 1, 1) + 1;
            seg.update(ans[i] - 1, -1, 0, size - 1, 1);
        }

        if (isNotPermutation) {
            sb.append("NIE");
        } else {
            for (int i = 0; i < size; i++) {
                sb.append(ans[i]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(Seg seg, int[] arr, int idx) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int sum = seg.query(mid, 0, arr.length - 1, 1);

            if (sum <= arr[idx]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left + 1;
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
            return (tree[node * 2 + 1] > k ? query(k, mid + 1, r, node * 2 + 1) : query(k - tree[node * 2 + 1], l, mid, node * 2));
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
