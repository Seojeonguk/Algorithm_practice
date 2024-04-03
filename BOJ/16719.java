import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] str = br.readLine().toCharArray();
        boolean[] isVisit = new boolean[str.length];

        solve(str, isVisit, 0, str.length - 1, sb);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(char[] str, boolean[] isVisit, int l, int r, StringBuilder sb) {
        if (l > r) {
            return;
        }
        char min = Character.MAX_VALUE;
        int minIdx = -1;

        for (int idx = l; idx <= r; idx++) {
            if (min > str[idx]) {
                min = str[idx];
                minIdx = idx;
            }
        }

        if (minIdx == -1) {
            return;
        }

        isVisit[minIdx] = true;
        for (int i = 0; i < str.length; i++) {
            if (isVisit[i]) {
                sb.append(str[i]);
            }
        }
        sb.append("\n");
        solve(str, isVisit, minIdx + 1, r, sb);
        solve(str, isVisit, l, minIdx - 1, sb);
    }
}
