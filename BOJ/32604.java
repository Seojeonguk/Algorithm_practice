import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int TOTAL_TEAM = 2;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int receivedPictureNum = Integer.parseInt(br.readLine());
            int[][] teamScores = new int[receivedPictureNum][TOTAL_TEAM];

            for (int i = 0; i < receivedPictureNum; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < TOTAL_TEAM; j++) {
                    teamScores[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(isOrder(teamScores) ? "yes" : "no");

            bw.write(sb.toString());
        }
    }

    public static boolean isOrder(int[][] teamScores) {
        int[] prevTeamScores = new int[TOTAL_TEAM];

        for (int[] nextTeamScores : teamScores) {
            for (int j = 0; j < TOTAL_TEAM; j++) {
                if (nextTeamScores[j] < prevTeamScores[j]) {
                    return false;
                }

                prevTeamScores[j] = nextTeamScores[j];
            }
        }

        return true;
    }
}
