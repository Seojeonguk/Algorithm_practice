import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        while (true) {
            st = new StringTokenizer(br.readLine());
            int sleepingHour = Integer.parseInt(st.nextToken());
            int sleepingMinute = Integer.parseInt(st.nextToken());

            int alarmHour = Integer.parseInt(st.nextToken());
            int alarmMinute = Integer.parseInt(st.nextToken());

            if (sleepingHour == 0 && sleepingMinute == 0 && alarmHour == 0 && alarmMinute == 0) {
                break;
            }

            int sleepingTotalMinutes = sleepingHour * 60 + sleepingMinute;
            int alarmTotalMinutes = alarmHour * 60 + alarmMinute;

            if (sleepingTotalMinutes > alarmTotalMinutes) {
                alarmTotalMinutes += 24 * 60;
            }
            sb.append(alarmTotalMinutes - sleepingTotalMinutes).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
