import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int euclideanCnt = 0;
        while (A != B) {
            int max = Math.max(A, B);
            int min = Math.min(A, B);
            A = max - min;
            B = min;
            euclideanCnt++;
        }
        sb.append(euclideanCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
