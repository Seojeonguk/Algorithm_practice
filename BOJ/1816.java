import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MAX = (int) 1e6;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            long s = Long.parseLong(br.readLine());
            boolean isGoodPrivateKey = true;
            for (int j = 2; j <= MAX; j++) {
                if (s % j == 0) {
                    isGoodPrivateKey = false;
                    break;
                }
            }
            sb.append(isGoodPrivateKey ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
