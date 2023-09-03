import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int childrenCnt = Integer.parseInt(st.nextToken());
        int tryCnt = Integer.parseInt(st.nextToken());

        long[] candy = new long[tryCnt];
        long[] prefixSum = new long[tryCnt];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < tryCnt; idx++) {
            candy[idx] = Long.parseLong(st.nextToken());
            prefixSum[idx] = (idx > 0 ? prefixSum[idx - 1] : 0) + candy[idx];
        }

        for (int i = 0; i < childrenCnt; i++) {
            long candyQuantity = Long.parseLong(br.readLine());
            int idx = Arrays.binarySearch(prefixSum, candyQuantity);
            int pullCnt = (idx >= 0 ? idx + 1 : -idx);
            sb.append(pullCnt > tryCnt ? "Go away!" : pullCnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
