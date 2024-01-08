import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int totalMachine = Integer.parseInt(br.readLine());

        int[] aMachines = new int[totalMachine];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalMachine; i++) {
            aMachines[i] = Integer.parseInt(st.nextToken());
        }

        int[] bMachines = new int[totalMachine];
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> bMachineIndexes = new HashMap<>();
        for (int i = 0; i < totalMachine; i++) {
            bMachines[i] = Integer.parseInt(st.nextToken());
            bMachineIndexes.put(bMachines[i], i);
        }

        Seg seg = new Seg(totalMachine * 4);

        long crossCableCnt = 0;
        for (int i = 0; i < totalMachine; i++) {
            int bMachineIndex = bMachineIndexes.get(aMachines[i]);
            int crossCable = seg.query(bMachineIndex, totalMachine - 1, 0, totalMachine - 1, 1);
            seg.update(bMachineIndex, 1, 0, totalMachine - 1, 1);
            crossCableCnt += crossCable;
        }

        sb.append(crossCableCnt);

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
