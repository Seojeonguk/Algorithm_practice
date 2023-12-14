import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            int totalParticipant = Integer.parseInt(st.nextToken());
            int totalCompetitionDay = Integer.parseInt(st.nextToken());
            int johnLastYearID = Integer.parseInt(st.nextToken());

            int[][] scoreboards = new int[totalParticipant + 1][totalCompetitionDay + 1];
            int[] maxScoreOnCompetitionDay = new int[totalCompetitionDay + 1];
            for (int participant = 1; participant <= totalParticipant; participant++) {
                st = new StringTokenizer(br.readLine());
                for (int competitionDay = 1; competitionDay <= totalCompetitionDay; competitionDay++) {
                    scoreboards[participant][competitionDay] = Integer.parseInt(st.nextToken());
                    if (participant != johnLastYearID) {
                        maxScoreOnCompetitionDay[competitionDay] = Math.max(maxScoreOnCompetitionDay[competitionDay], scoreboards[participant][competitionDay]);
                    }
                }
            }

            int minimumAdditionalSteps = 0;
            for (int competitionDay = 1; competitionDay <= totalCompetitionDay; competitionDay++) {
                minimumAdditionalSteps += Math.max(0, maxScoreOnCompetitionDay[competitionDay] - scoreboards[johnLastYearID][competitionDay]);
            }

            sb.append("Case #").append(tc).append(": ").append(minimumAdditionalSteps).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
