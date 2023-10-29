import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int currentBusPassenger = 0;
        int busStationCnt = Integer.parseInt(st.nextToken());
        int seatCnt = Integer.parseInt(st.nextToken());

        int maxStandingCnt = 0;
        for (int busStation = 0; busStation < busStationCnt; busStation++) {
            st = new StringTokenizer(br.readLine());
            int ridingCnt = Integer.parseInt(st.nextToken());
            int stopOver = Integer.parseInt(st.nextToken());

            currentBusPassenger += ridingCnt - stopOver;
            maxStandingCnt = Math.max(maxStandingCnt, currentBusPassenger - seatCnt);
        }

        sb.append(maxStandingCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
