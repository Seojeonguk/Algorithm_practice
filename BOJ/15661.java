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
        int personCnt = Integer.parseInt(br.readLine());

        int[][] stats = new int[personCnt][personCnt];
        for (int i = 0; i < personCnt; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < personCnt; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] selected = new boolean[1 << personCnt];

        int minTeamStatDiff = getMinTeamStatDiff(stats, selected, 0, 0);
        sb.append(minTeamStatDiff);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getMinTeamStatDiff(int[][] stats, boolean[] selected, int selectedCnt, int state) {
        if (selectedCnt == stats.length + 1) {
            int teamDiff = calTeamStatDiff(stats, state);
            return teamDiff;
        }

        int minTeamStatDiff = calTeamStatDiff(stats, state);
        for (int i = 0; i < stats.length; i++) {
            int nextState = (state | (1 << i));
            if (selected[nextState]) {
                continue;
            }
            selected[nextState] = true;
            minTeamStatDiff = Math.min(minTeamStatDiff, getMinTeamStatDiff(stats, selected, selectedCnt + 1, nextState));
        }

        return minTeamStatDiff;
    }

    public static int calTeamStatDiff(int[][] stats, int state) {
        int sumStartTeamStat = 0, sumLinkTeamStat = 0;

        for (int i = 0; i < stats.length; i++) {
            for (int j = 0; j < stats.length; j++) {
                boolean isFirstStartTeam = ((state & (1 << i)) == 0 ? false : true);
                boolean isSecondStartTeam = ((state & (1 << j)) == 0 ? false : true);

                if (isFirstStartTeam && isSecondStartTeam) {
                    sumStartTeamStat += stats[i][j] + stats[j][i];
                } else if (!isFirstStartTeam && !isSecondStartTeam) {
                    sumLinkTeamStat += stats[i][j] + stats[j][i];
                }
            }
        }

        return Math.abs(sumStartTeamStat - sumLinkTeamStat) / 2;
    }
}
