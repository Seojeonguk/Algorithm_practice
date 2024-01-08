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

    static final int TASTE_MAX = 1000000;

    public static void main(String[] args) throws Exception {
        int touchCnt = Integer.parseInt(br.readLine());

        Seg seg = new Seg(TASTE_MAX * 4);
        seg.init(0, TASTE_MAX, 1);

        while (touchCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int candyRank = Integer.parseInt(st.nextToken());
                int candyNum = seg.query(candyRank, 0, TASTE_MAX, 1);
                sb.append(candyNum).append("\n");

                seg.update(candyNum, -1, 0, TASTE_MAX, 1);
            } else if (command == 2) {
                int candyTaste = Integer.parseInt(st.nextToken());
                int candyCnt = Integer.parseInt(st.nextToken());

                seg.update(candyTaste, candyCnt, 0, TASTE_MAX, 1);
            }
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

        int init(int l, int r, int node) {
            if (l == r) {
                return tree[node] = 0;
            }
            int mid = (l + r) / 2;
            int left = init(l, mid, node * 2);
            int right = init(mid + 1, r, node * 2 + 1);

            return tree[node];
        }

        int query(int rank, int l, int r, int node) {
            if (l == r) {
                return l;
            }

            int mid = (l + r) / 2;

            return (rank <= tree[node * 2] ? query(rank, l, mid, node * 2) : query(rank - tree[node * 2], mid + 1, r, node * 2 + 1));
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

            return tree[node] = (left + right);
        }
    }
}
