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
        int courseLength = Integer.parseInt(st.nextToken());
        int viewRange = Integer.parseInt(st.nextToken());
        int[] billboardLightIntensities = new int[courseLength];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < courseLength; i++) {
            billboardLightIntensities[i] = Integer.parseInt(st.nextToken());
        }

        Seg seg = new Seg(courseLength * 4);
        seg.init(billboardLightIntensities, 0, courseLength - 1, 1);

        for (int i = viewRange - 1; i < courseLength - viewRange + 1; i++) {
            sb.append(seg.query(i - viewRange + 1, i + viewRange - 1, 0, courseLength - 1, 1)).append(" ");
        }

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

        int init(int[] arr, int l, int r, int node) {
            if (l == r) {
                return tree[node] = arr[l];
            }
            int mid = (l + r) / 2;
            return tree[node] = Math.max(init(arr, l, mid, node * 2), init(arr, mid + 1, r, node * 2 + 1));
        }

        int query(int l, int r, int nL, int nR, int node) {
            if (nR < l || nL > r) {
                return 0;
            }
            if (l <= nL && nR <= r) {
                return tree[node];
            }
            int mid = (nL + nR) / 2;

            return Math.max(query(l, r, nL, mid, node * 2), query(l, r, mid + 1, nR, node * 2 + 1));
        }
    }
}
