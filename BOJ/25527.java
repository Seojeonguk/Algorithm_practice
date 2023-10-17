import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        while (true) {
            int reportedDay = Integer.parseInt(br.readLine());
            if (reportedDay == 0) {
                break;
            }
            int[] infects = new int[reportedDay];
            st = new StringTokenizer(br.readLine());
            for (int day = 0; day < reportedDay; day++) {
                infects[day] = Integer.parseInt(st.nextToken());
            }
            int peek = 0;
            for (int day = 1; day < reportedDay - 1; day++) {
                if (infects[day - 1] < infects[day] && infects[day + 1] < infects[day]) {
                    peek++;
                }
            }
            sb.append(peek).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
