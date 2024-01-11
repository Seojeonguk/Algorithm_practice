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
        String str;
        while ((str = br.readLine()) != null) {
            String[] strSplit = str.split(" ");

            int arrSize = Integer.parseInt(strSplit[0]);
            int totalRound = Integer.parseInt(strSplit[1]);

            int[] arr = new int[arrSize];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arrSize; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Seg seg = new Seg(arrSize * 4);
            seg.init(arr, 0, arrSize - 1, 1);

            while (totalRound-- > 0) {
                st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                if (command == 'C') {
                    int pos = Integer.parseInt(st.nextToken());
                    int value = Integer.parseInt(st.nextToken());
                    seg.update(pos - 1, value, 0, arrSize - 1, 1);
                } else if (command == 'P') {
                    int l = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());

                    int sum = seg.query(l - 1, r - 1, 0, arrSize - 1, 1);
                    if (sum > 0) {
                        sb.append("+");
                    } else if (sum < 0) {
                        sb.append("-");
                    } else {
                        sb.append("0");
                    }
                }
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
                return tree[node] = (arr[l] == 0 ? 0 : (arr[l] > 0 ? 1 : -1));
            }
            int mid = (l + r) / 2;
            return tree[node] = init(arr, l, mid, node * 2) * init(arr, mid + 1, r, node * 2 + 1);
        }

        int query(int l, int r, int nL, int nR, int node) {
            if (l > nR || r < nL) {
                return 1;
            }
            if (l <= nL && nR <= r) {
                return tree[node];
            }

            int mid = (nL + nR) / 2;
            return query(l, r, nL, mid, node * 2) * query(l, r, mid + 1, nR, node * 2 + 1);
        }

        int update(int pos, int value, int l, int r, int node) {
            if (pos < l || r < pos) {
                return tree[node];
            }
            if (l == r) {
                return tree[node] = (value == 0 ? 0 : (value > 0 ? 1 : -1));
            }

            int mid = (l + r) / 2;
            return tree[node] = update(pos, value, l, mid, node * 2) * update(pos, value, mid + 1, r, node * 2 + 1);
        }
    }
}
