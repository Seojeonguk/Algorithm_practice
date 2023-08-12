import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int MIDNIGHT = 24 * 60;

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= tc; testCase++) {
            st = new StringTokenizer(br.readLine());
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());

            int totalMinuteFromTime = hour * 60 + minute;
            int timeToEatSnack = (totalMinuteFromTime - 45 + MIDNIGHT) % MIDNIGHT;

            sb.append(String.format("Case #%d: %d %d\n", testCase, timeToEatSnack / 60, timeToEatSnack % 60));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
