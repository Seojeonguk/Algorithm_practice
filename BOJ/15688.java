import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int MAX_VALUE = 1000000;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] cnt = new int[2 * MAX_VALUE + 1];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine()) + MAX_VALUE;
            cnt[x]++;
        }

        for (int i = 0; i < 2 * MAX_VALUE + 1; i++) {
            while (cnt[i] > 0) {
                sb.append(i - MAX_VALUE).append("\n");
                cnt[i]--;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
