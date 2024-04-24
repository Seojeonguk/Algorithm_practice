import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int A_CORNET_COST = 5000;
    static final int B_CORNET_COST = 1000;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer intTokenizer = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(intTokenizer.nextToken());
            int budget = Integer.parseInt(intTokenizer.nextToken());

            int[][] menuScores = new int[days][2];
            int maxScore = 0;

            for (int day = 0; day < days; day++) {
                StringTokenizer scoresTokenizer = new StringTokenizer(br.readLine());
                menuScores[day][0] = Integer.parseInt(scoresTokenizer.nextToken());
                menuScores[day][1] = Integer.parseInt(scoresTokenizer.nextToken());

                maxScore += menuScores[day][1];
                budget -= B_CORNET_COST;
            }

            Arrays.sort(menuScores, (o1, o2) -> Integer.compare(Math.abs(o2[0] - o2[1]), Math.abs(o1[0] - o1[1])));

            for (int i = 0; i < days && budget >= A_CORNET_COST - B_CORNET_COST; i++) {
                if (menuScores[i][0] > menuScores[i][1]) {
                    maxScore += menuScores[i][0] - menuScores[i][1];
                    budget -= A_CORNET_COST - B_CORNET_COST;
                }
            }

            sb.append(maxScore);

            bw.write(sb.toString());
        }
    }
}
