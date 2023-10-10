import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int juhoFrog = Integer.parseInt(st.nextToken());
        int frogCnt = Integer.parseInt(st.nextToken());

        int[] frogPlace = new int[frogCnt];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < frogCnt; idx++) {
            frogPlace[idx] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int jump = Integer.parseInt(st.nextToken());
        int walkingEnergy = Integer.parseInt(st.nextToken());

        int minFrogEnergy = Integer.MAX_VALUE;
        int frogNum = -1;

        for (int idx = 0; idx < frogCnt; idx++) {
            int diff = Math.abs(juhoFrog - frogPlace[idx]);
            int energyToMeetFrogs = (diff > 2 * jump ? (diff - 2 * jump) * walkingEnergy : 2 * jump - diff);
            if (minFrogEnergy > energyToMeetFrogs) {
                minFrogEnergy = energyToMeetFrogs;
                frogNum = idx + 1;
            }
        }
        sb.append(minFrogEnergy).append(" ").append(frogNum);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
