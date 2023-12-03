import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        boolean[] selected = new boolean[10];
        int[] values = new int[7];

        solve(n, selected, 0, values);

        if (sb.length() == 0) {
            sb.append("No Answer");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(int n, boolean[] selected, int selectedCnt, int[] values) {
        if (sb.length() != 0) {
            return;
        }

        if ((selectedCnt == 3 && values[2] == 0) || (selectedCnt == values.length && values[6] == 0)) {
            return;
        }

        if (selectedCnt == values.length) {
            int hello = values[2] * 10000 + values[1] * 1000 + values[3] * 100 + values[3] * 10 + values[4];
            int world = values[6] * 10000 + values[4] * 1000 + values[5] * 100 + values[3] * 10 + values[0];

            if (hello + world == n) {
                sb.append("  ").append(values[2]).append(values[1]).append(values[3]).append(values[3]).append(values[4]).append("\n")
                        .append("+ ").append(values[6]).append(values[4]).append(values[5]).append(values[3]).append(values[0]).append("\n")
                        .append("-------").append("\n")
                        .append(String.format("%7d", n));
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (selected[i]) {
                continue;
            }
            selected[i] = true;
            values[selectedCnt] = i;
            solve(n, selected, selectedCnt + 1, values);
            values[selectedCnt] = 0;
            selected[i] = false;
        }
    }
}
