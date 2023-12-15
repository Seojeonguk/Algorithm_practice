import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String[] todayTimes = br.readLine().split(":");
        int todayHour = Integer.parseInt(todayTimes[0]);
        int todayMinute = Integer.parseInt(todayTimes[1]);
        int totalTodayMinute = todayHour * 60 + todayMinute;

        String[] tomorrowTimes = br.readLine().split(":");
        int tomorrowHour = Integer.parseInt(tomorrowTimes[0]);
        int tomorrowMinute = Integer.parseInt(tomorrowTimes[1]);
        int totalTomorrowMinute = tomorrowHour * 60 + tomorrowMinute;

        int takeTime = 24 * 60 + totalTomorrowMinute - totalTodayMinute;
        sb.append(String.format("%02d:%02d", takeTime / 60, takeTime % 60));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
