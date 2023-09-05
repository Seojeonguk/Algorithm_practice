import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MAX = 45;

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        long[] f = new long[MAX + 1];
        f[0] = f[1] = 1;
        for (int i = 2; i <= MAX; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        for (int tc = 0; tc < testCase; tc++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(f[x]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
