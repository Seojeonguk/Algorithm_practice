import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        String[] start = st.nextToken().split(":");
        String[] finish = st.nextToken().split(":");

        int startMinute = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        int finishMinute = Integer.parseInt(finish[0]) * 60 + Integer.parseInt(finish[1]);

        st = new StringTokenizer(br.readLine());
        int parcelCnt = Integer.parseInt(st.nextToken());
        int parcelTime = Integer.parseInt(st.nextToken());
        int parcelPerDay = (finishMinute - startMinute - 1) / parcelTime;

        int day = parcelCnt / parcelPerDay;
        int time = startMinute + (parcelCnt - day * parcelPerDay + 1) * parcelTime;

        sb.append(String.format("%d\n%02d:%02d", day, time / 60, time % 60));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
