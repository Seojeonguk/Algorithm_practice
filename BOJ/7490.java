import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            solve(n, 1, "1");
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(int n, int cur, String str) {
        if (cur == n) {
            if (isZero(str)) {
                sb.append(str).append("\n");
            }
            return;
        }

        solve(n, cur + 1, str + " " + (cur + 1));
        solve(n, cur + 1, str + "+" + (cur + 1));
        solve(n, cur + 1, str + "-" + (cur + 1));
    }

    public static boolean isZero(String str) {
        String deletedSpace = str.replaceAll(" ", "");
        Iterator<Integer> it = Arrays.stream(deletedSpace.split("[+,-]")).mapToInt(Integer::parseInt).iterator();

        int res = it.next();
        for (int idx = 0; idx < deletedSpace.length(); idx++) {
            char c = deletedSpace.charAt(idx);
            if (c == '+') {
                res += it.next();
            } else if (c == '-') {
                res -= it.next();
            }
        }
        return res == 0;
    }
}
