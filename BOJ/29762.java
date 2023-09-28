import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        sb.append(solve(n));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String solve(int n) {
        String ans = String.valueOf(n);
        if (ans.length() < 4) {
            return ans;
        }
        int minAnsLength = ans.length();
        long sqrt = (long) Math.sqrt(n);
        for (long i = 1; i <= sqrt; i++) {
            if (n % i != 0) {
                continue;
            }
            for (long j = 2; i * j * j <= n; j++) {
                int pow = 2;
                long cur = i * j * j;
                while (cur < n) {
                    cur *= j;
                    pow++;
                }
                if (cur != n) {
                    continue;
                }
                int curLength = String.valueOf(j).length() + String.valueOf(pow).length() + (i == 1 ? 0 : String.valueOf(i).length()) + 1;
                if (minAnsLength > curLength) {
                    minAnsLength = curLength;
                    if (i == 1) {
                        ans = String.format("%d %d ^", j, pow);
                    } else {
                        ans = String.format("%d %d %d ^ *", i, j, pow);
                    }
                }
            }
        }
        return ans;
    }
}
