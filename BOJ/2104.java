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
        long[] prefixSum = new long[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = (i == 0 ? 0 : prefixSum[i - 1]) + arr[i];
        }
        Seg seg = new Seg(size * 4);
        seg.init(arr, 0, size - 1, 1);

        sb.append(solve(seg, prefixSum, arr, 0, size - 1));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long solve(Seg seg, long[] prefixSum, int[] arr, int l, int r) {
        int minIdx = seg.query(arr, l, r, 0, prefixSum.length - 1, 1);
        long sum = (prefixSum[r] - (l == 0 ? 0 : prefixSum[l - 1])) * arr[minIdx];

        long maxValue = sum;
        if (minIdx - 1 >= l) {
            long leftAnswer = solve(seg, prefixSum, arr, l, minIdx - 1);
            maxValue = Math.max(maxValue, leftAnswer);
        }
        if (minIdx + 1 <= r) {
            long rightAnswer = solve(seg, prefixSum, arr, minIdx + 1, r);
            maxValue = Math.max(maxValue, rightAnswer);
        }

        return maxValue;
    }

    static class Seg {
        int[] tree;

        Seg(int size) {
            tree = new int[size];
        }

        int init(int[] arr, int l, int r, int node) {
            if (l == r) {
                return tree[node] = l;
            }
            int mid = (l + r) / 2;
            int left = init(arr, l, mid, node * 2);
            int right = init(arr, mid + 1, r, node * 2 + 1);

            return tree[node] = (arr[left] < arr[right] ? left : right);
        }

        int query(int[] arr, int l, int r, int nL, int nR, int node) {
            if (nR < l || nL > r) {
                return -1;
            }
            if (l <= nL && nR <= r) {
                return tree[node];
            }
            int mid = (nL + nR) / 2;
            int left = query(arr, l, r, nL, mid, node * 2);
            int right = query(arr, l, r, mid + 1, nR, node * 2 + 1);

            if (left < 0) {
                return right;
            }
            if (right < 0) {
                return left;
            }

            return (arr[left] < arr[right] ? left : right);
        }
    }
}
