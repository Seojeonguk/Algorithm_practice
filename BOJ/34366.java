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
        int months = Integer.parseInt(br.readLine());

        int maxScore = 0;
        int minScore = Integer.MAX_VALUE;
        int maxMonthScore = 0;
        int minMonthScore = Integer.MAX_VALUE;

        for (int i = 0; i < months; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gameCnt = Integer.parseInt(st.nextToken());

            int sumScore = 0;
            for (int j = 0; j < gameCnt; j++) {
                int score = Integer.parseInt(st.nextToken());
                maxScore = Math.max(maxScore, score);
                minScore = Math.min(minScore, score);

                sumScore += score;
            }
            maxMonthScore = Math.max(maxMonthScore, sumScore);
            minMonthScore = Math.min(minMonthScore, sumScore);
        }

        sb.append(maxScore).append("\n")
                .append(minScore).append("\n")
                .append(maxMonthScore).append("\n")
                .append(minMonthScore).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }
}
