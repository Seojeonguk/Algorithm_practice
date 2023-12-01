import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int seminarStartHour = Integer.parseInt(st.nextToken());
        int seminarStartMinute = Integer.parseInt(st.nextToken());

        int totalSeminarStartMinute = seminarStartHour * 60 + seminarStartMinute;

        int participantRegisterMinute = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int moveHour = Integer.parseInt(st.nextToken());
        int moveMinute = Integer.parseInt(st.nextToken());

        int totalMoveMinute = moveHour * 60 + moveMinute;

        int participantExcludeLeader = Integer.parseInt(br.readLine());
        int unpackMinute = Integer.parseInt(br.readLine());

        int minStartTime = totalSeminarStartMinute - 10 - participantRegisterMinute - totalMoveMinute - (participantExcludeLeader + 1) * unpackMinute;

        sb.append(String.format("%02d %02d", minStartTime / 60, minStartTime % 60));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
