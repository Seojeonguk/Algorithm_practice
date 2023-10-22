import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int workCnt = Integer.parseInt(br.readLine());
        String work = br.readLine();

        int ballIdx = 1;
        int thirdBoxCnt = 0;
        for (int idx = 0; idx < workCnt; idx++) {
            char c = work.charAt(idx);
            if (c == 'L') {
                ballIdx = Math.max(1, ballIdx - 1);
            } else if (c == 'R') {
                ballIdx = Math.min(3, ballIdx + 1);
            }
            if (ballIdx == 3) {
                thirdBoxCnt++;
            }
        }

        sb.append(thirdBoxCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
