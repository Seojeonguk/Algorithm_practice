import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int kindergartenerCnt = Integer.parseInt(st.nextToken());
        int groupCnt = Integer.parseInt(st.nextToken());
        int[] kindergartenerHeights = new int[kindergartenerCnt];
        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int idx = 0; idx < kindergartenerCnt; idx++) {
            kindergartenerHeights[idx] = Integer.parseInt(st.nextToken());
            if (idx > 0) {
                pq.add(kindergartenerHeights[idx] - kindergartenerHeights[idx - 1]);
            }
        }

        int ans = 0;
        while (!pq.isEmpty() && pq.size() >= groupCnt) {
            ans += pq.poll();
        }
        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
