import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MAX_MINUTE = 60;
    final static int MAX_SECOND = 60;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int hours = Integer.parseInt(st.nextToken());
        String containedNum = st.nextToken();

        int totalContainedCnt = 0;
        for (int hour = 0; hour <= hours; hour++) {
            if (String.format("%02d", hour).contains(containedNum)) {
                totalContainedCnt += MAX_MINUTE * MAX_SECOND;
                continue;
            }
            for (int minute = 0; minute < MAX_MINUTE; minute++) {
                if (String.format("%02d", minute).contains(containedNum)) {
                    totalContainedCnt += MAX_SECOND;
                    continue;
                }
                for (int second = 0; second < MAX_SECOND; second++) {
                    if (String.format("%02d", second).contains(containedNum)) {
                        totalContainedCnt++;
                    }
                }
            }
        }
        sb.append(totalContainedCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
