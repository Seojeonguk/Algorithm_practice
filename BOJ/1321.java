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
        int totalUnit = Integer.parseInt(br.readLine());
        int[] militaryMans = new int[totalUnit];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalUnit; i++) {
            militaryMans[i] = Integer.parseInt(st.nextToken());
        }

        Seg seg = new Seg(totalUnit * 4);
        seg.init(militaryMans, 0, totalUnit - 1, 1);

        int totalCommand = Integer.parseInt(br.readLine());
        while (totalCommand-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int militaryNum = Integer.parseInt(st.nextToken());
                int changedPerson = Integer.parseInt(st.nextToken());
                seg.update(militaryNum - 1, changedPerson, 0, totalUnit - 1, 1);
            } else if (command == 2) {
                int soldierNum = Integer.parseInt(st.nextToken());

                int l = 0, r = totalUnit - 1;
                while (l <= r) {
                    int mid = (l + r) / 2;

                    int sum = seg.query(0, mid, 0, totalUnit - 1, 1);

                    if (sum >= soldierNum) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                sb.append(l + 1).append("\n");
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
