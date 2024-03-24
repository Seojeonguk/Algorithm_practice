import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer teamInfo = new StringTokenizer(br.readLine());
        int teamCnt = Integer.parseInt(teamInfo.nextToken());
        int damagedTeamCnt = Integer.parseInt(teamInfo.nextToken());
        int oneMoreTeamCnt = Integer.parseInt(teamInfo.nextToken());

        boolean[] cantStartTeams = new boolean[teamCnt + 2];
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(damagedTeam -> cantStartTeams[damagedTeam] = true);

        int[] oneMoreTeams = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(oneMoreTeams);

        ArrayList<Integer> giveAnotherTeams = new ArrayList<>();
        for (int team : oneMoreTeams) {
            if (cantStartTeams[team]) {
                cantStartTeams[team] = false;
            } else {
                giveAnotherTeams.add(team);
            }
        }

        for (int team : giveAnotherTeams) {
            if (cantStartTeams[team - 1]) {
                cantStartTeams[team - 1] = false;
            } else if (cantStartTeams[team + 1]) {
                cantStartTeams[team + 1] = false;
            }
        }

        int cantStartTeamCnt = 0;
        for (int teamNum = 1; teamNum <= teamCnt; teamNum++) {
            if (cantStartTeams[teamNum]) {
                cantStartTeamCnt++;
            }
        }

        sb.append(cantStartTeamCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
