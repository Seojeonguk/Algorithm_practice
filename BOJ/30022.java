import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int productCnt = Integer.parseInt(st.nextToken());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());

        long ans = 0;
        long[] diff = new long[productCnt];
        for (int i = 0; i < productCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            ans += p;
            diff[i] = q - p;
        }
        Arrays.sort(diff);
        for (int i = 0; i < right; i++) {
            ans += diff[i];
        }
        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
