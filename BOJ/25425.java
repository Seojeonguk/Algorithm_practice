import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long totalTeamCnt = Long.parseLong(st.nextToken());
        long teamPersonCnt = Long.parseLong(st.nextToken());
        long currentPersonCnt = Long.parseLong(st.nextToken());
        long JHTeam = Long.parseLong(st.nextToken());

        long JHAnotherPerson = currentPersonCnt - JHTeam;
        sb.append(Math.min(totalTeamCnt - 1, JHAnotherPerson) + 1).append(" ").append((JHAnotherPerson + teamPersonCnt - 1) / teamPersonCnt + 1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
