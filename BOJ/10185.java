import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            int objectDistance = Integer.parseInt(st.nextToken());
            int imageDistance = Integer.parseInt(st.nextToken());

            double focus = 1.0f * objectDistance * imageDistance / (objectDistance + imageDistance);

            sb.append(String.format("f = %.1f\n", focus));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}