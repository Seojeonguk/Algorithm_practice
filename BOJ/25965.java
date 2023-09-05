import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int KDA = 3;
    final static int KILL = 0;
    final static int DEATH = 1;
    final static int ASSIST = 2;
    final static int MIN_DONATION = 0;

    public static void main(String[] args) throws Exception {
        int gameCnt = Integer.parseInt(br.readLine());
        for (int game = 0; game < gameCnt; game++) {
            int missionCnt = Integer.parseInt(br.readLine());
            int[][] missions = new int[missionCnt][KDA];
            for (int mission = 0; mission < missionCnt; mission++) {
                st = new StringTokenizer(br.readLine());
                int killMoney = Integer.parseInt(st.nextToken());
                int deathMoney = Integer.parseInt(st.nextToken());
                int assistMoney = Integer.parseInt(st.nextToken());
                missions[mission][KILL] = killMoney;
                missions[mission][DEATH] = deathMoney;
                missions[mission][ASSIST] = assistMoney;
            }
            st = new StringTokenizer(br.readLine());
            int kill = Integer.parseInt(st.nextToken());
            int death = Integer.parseInt(st.nextToken());
            int assist = Integer.parseInt(st.nextToken());

            long totalDonation = 0;
            for (int mission = 0; mission < missionCnt; mission++) {
                long donation = (long) missions[mission][KILL] * kill;
                donation -= (long) missions[mission][DEATH] * death;
                donation += (long) missions[mission][ASSIST] * assist;

                if (donation < MIN_DONATION) {
                    continue;
                }
                totalDonation += donation;
            }
            sb.append(totalDonation).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
