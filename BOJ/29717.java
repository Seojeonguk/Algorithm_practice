import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            long n = Long.parseLong(br.readLine());

            long getExp = n * (n + 1) / 2;
            long left = 1, right = (long) 1e9;
            while (left <= right) {
                long mid = (left + right) / 2;
                if (mid * (mid + 1) <= getExp) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(left).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
