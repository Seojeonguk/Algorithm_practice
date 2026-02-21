import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int gameCnt = Integer.parseInt(br.readLine());
        int maxStreak = 0;
        int winStreak = 0;

        for (int i = 0; i < gameCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int analyzeTeamScore = Integer.parseInt(st.nextToken());
            int opponentTeamScore = Integer.parseInt(st.nextToken());

            if (analyzeTeamScore > opponentTeamScore) {
                winStreak += 1;
                maxStreak = Math.max(maxStreak, winStreak);
            } else {
                winStreak = 0;
            }
        }

        sb.append(maxStreak);

        bw.write(sb.toString());
        bw.flush();
    }
}
