import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int TIME_TO_CONCENTRATE = 8;
    final static String READING_ROOM = "Dok";
    final static String HOME = "Zip";

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long taskInHome = Long.parseLong(st.nextToken());
        long taskInReadingRoom = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long movingTime = Long.parseLong(st.nextToken());
        long sleepingTime = Long.parseLong(st.nextToken());

        long totalTimeInHome = taskInHome + (taskInHome - 1) / TIME_TO_CONCENTRATE * sleepingTime;
        long movingCnt = (taskInReadingRoom - 1) / TIME_TO_CONCENTRATE;

        long totalTimeInReadingRoom = taskInReadingRoom + (2 * movingCnt + 1) * movingTime + movingCnt * sleepingTime;

        sb.append(String.format("%s\n%d", totalTimeInHome > totalTimeInReadingRoom ? READING_ROOM : HOME, Math.min(totalTimeInHome, totalTimeInReadingRoom)));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
