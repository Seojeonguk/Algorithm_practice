import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int frameCnt = Integer.parseInt(br.readLine());

        int largestFrameSquare = 0;
        for (int i = 0; i < frameCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());

            if (height * width > largestFrameSquare) {
                largestFrameSquare = height * width;
            }
        }
        sb.append(largestFrameSquare);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
