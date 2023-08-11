import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < tc; testCase++) {
            st = new StringTokenizer(br.readLine());
            int totalDaysInYear = Integer.parseInt(st.nextToken());
            int weekMDays = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());

            int ans = 0;
            for (int i = 0; i < totalDaysInYear; i++) {
                int day = startDay + i - 1;
                if (day % weekMDays == 0) {
                    ans++;
                }
            }
            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
