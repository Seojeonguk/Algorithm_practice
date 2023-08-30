import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static long MAX = 1000000L;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int staffCnt = Integer.parseInt(st.nextToken());
        int balloonCnt = Integer.parseInt(st.nextToken());
        int[] timeToMakeBalloons = new int[staffCnt];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < staffCnt; idx++) {
            timeToMakeBalloons[idx] = Integer.parseInt(st.nextToken());
        }
        long left = 0, right = MAX * MAX;
        while (left <= right) {
            long mid = (left + right) / 2;
            long possibleBalloonCnt = 0;
            for (int idx = 0; idx < staffCnt; idx++) {
                possibleBalloonCnt += mid / timeToMakeBalloons[idx];
            }
            if (possibleBalloonCnt >= balloonCnt) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        sb.append(left);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
