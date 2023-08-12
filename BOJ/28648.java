import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        int busCnt = Integer.parseInt(br.readLine());

        int earliestArrivalTime = 201;
        for (int i = 0; i < busCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int busPassTime = Integer.parseInt(st.nextToken());
            int busTravelTimeToMail = Integer.parseInt(st.nextToken());

            earliestArrivalTime = Math.min(earliestArrivalTime, busPassTime + busTravelTimeToMail);
        }

        sb.append(earliestArrivalTime);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
