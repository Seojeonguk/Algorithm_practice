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
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int totalDVD = Integer.parseInt(st.nextToken());
            int watchDVDCnt = Integer.parseInt(st.nextToken());
            int totalSize = totalDVD + watchDVDCnt - 1;
            int lastIdx = watchDVDCnt + totalDVD;

            Seg seg = new Seg(lastIdx * 4);
            int[] DVDIndexes = new int[totalDVD + 1];
            int[] arr = new int[lastIdx];
            for (int DVDCnt = totalDVD; DVDCnt >= 1; DVDCnt--) {
                arr[--lastIdx] = DVDCnt;
                DVDIndexes[DVDCnt] = lastIdx;
            }

            seg.init(arr, 0, totalSize, 1);

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < watchDVDCnt; i++) {
                int watchDVD = Integer.parseInt(st.nextToken());
                int DVDIndex = DVDIndexes[watchDVD];

                int upperDVD = seg.query(0, DVDIndex - 1, 0, totalSize, 1);
                sb.append(upperDVD).append(" ");

                seg.update(DVDIndex, -1, 0, totalSize, 1);
                DVDIndexes[watchDVD] = --lastIdx;
                seg.update(lastIdx, 1, 0, totalSize, 1);
            }
            sb.append("\n");
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
                return tree[node] = (arr[l] > 0 ? 1 : 0);
            }
            int mid = (l + r) / 2;
            return tree[node] = init(arr, l, mid, node * 2) + init(arr, mid + 1, r, node * 2 + 1);
        }

        int query(int l, int r, int nL, int nR, int node) {
            if (l > nR || r < nL) {
                return 0;
            }
            if (l <= nL && nR <= r) {
                return tree[node];
            }

            int mid = (nL + nR) / 2;
            return query(l, r, nL, mid, node * 2) + query(l, r, mid + 1, nR, node * 2 + 1);
        }

        int update(int pos, int value, int l, int r, int node) {
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
