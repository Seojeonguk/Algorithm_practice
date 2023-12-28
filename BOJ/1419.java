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
        int l = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int ablePairCnt = solve(l, r, k);
        sb.append(ablePairCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int l, int r, int k) {
        int res = 0;
        if (k == 2) {
            res = Math.max(0, r - Math.max(l, 3) + 1);
        } else if (k == 3) {
            res = Math.max(0, r / 3 - (Math.max(l, 6) - 1) / 3);
        } else if (k == 4) {
            res = Math.max(0, r / 2 - (Math.max(l, 10) - 1) / 2 - (l <= 12 && r >= 12 ? 1 : 0));
        } else if (k == 5) {
            res = Math.max(0, r / 5 - (Math.max(l, 15) - 1) / 5);
        }
        return res;
    }
}
