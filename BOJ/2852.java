import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int BASKETBALL_GAME_TIME = 48;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int goalCnt = Integer.parseInt(br.readLine());

        Team[] teams = new Team[2];
        teams[0] = new Team();
        teams[1] = new Team();
        int goalDiff = 0;

        for (int goal = 0; goal < goalCnt; goal++) {
            StringTokenizer goalInfo = new StringTokenizer(br.readLine());
            int goalTeam = Integer.parseInt(goalInfo.nextToken());
            int goalTime = convertStrToInteger(goalInfo.nextToken());

            goalDiff += (goalTeam == 1 ? -1 : 1);

            if (goalDiff == 0) {
                teams[goalTeam == 1 ? 1 : 0].addWinningTime(goalTime);
            } else {
                if (Math.abs(goalDiff) != 1) {
                    continue;
                }
                teams[goalTeam == 1 ? 0 : 1].setLastStatedWinningTime(goalTime);
            }
        }

        if (goalDiff != 0) {
            teams[goalDiff > 0 ? 1 : 0].addWinningTime(BASKETBALL_GAME_TIME * 60);
        }

        for (Team team : teams) {
            sb.append(printFormatter(team.winningTime));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Team {
        int winningTime;
        int lastStatedWinningTime;

        Team() {
            this.winningTime = 0;
            this.lastStatedWinningTime = 0;
        }

        public void addWinningTime(int goalTIme) {
            this.winningTime += goalTIme - this.lastStatedWinningTime;
        }

        public void setLastStatedWinningTime(int time) {
            this.lastStatedWinningTime = time;
        }
    }

    public static String printFormatter(int time) {
        return String.format("%02d:%02d\n", time / 60, time % 60);
    }

    public static int convertStrToInteger(String time) {
        String[] times = time.split(":");
        int timeSeconds = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);

        return timeSeconds;
    }
}
