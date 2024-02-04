import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int DART_THROW_COUNT = 3;
    static final int[] DART_RADIUS = {3, 6, 9, 12, 15};
    static final int[] DART_SCORES = {100, 80, 60, 40, 20};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            double[][] firstPlayerDistanceRecords = new double[DART_THROW_COUNT][2];
            double[][] secondPlayerDistanceRecords = new double[DART_THROW_COUNT][2];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < DART_THROW_COUNT; i++) {
                firstPlayerDistanceRecords[i][0] = Double.parseDouble(st.nextToken());
                firstPlayerDistanceRecords[i][1] = Double.parseDouble(st.nextToken());
            }

            for (int i = 0; i < DART_THROW_COUNT; i++) {
                secondPlayerDistanceRecords[i][0] = Double.parseDouble(st.nextToken());
                secondPlayerDistanceRecords[i][1] = Double.parseDouble(st.nextToken());
            }

            int firstPlayerScore = calScore(firstPlayerDistanceRecords);
            int secondPlayerScore = calScore(secondPlayerDistanceRecords);

            if (firstPlayerScore == secondPlayerScore) {
                sb.append(String.format("SCORE: %d to %d, TIE.\n", firstPlayerScore, secondPlayerScore));
            } else {
                sb.append(String.format("SCORE: %d to %d, PLAYER %d WINS.\n", firstPlayerScore, secondPlayerScore, (firstPlayerScore > secondPlayerScore ? 1 : 2)));
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calScore(double[][] records) {
        int score = 0;
        for (int i = 0; i < records.length; i++) {
            double sqrtX = records[i][0] * records[i][0];
            double sqrtY = records[i][1] * records[i][1];

            for (int j = 0; j < DART_RADIUS.length; j++) {
                double sqrtR = (double) DART_RADIUS[j] * DART_RADIUS[j];

                if (sqrtX + sqrtY <= sqrtR) {
                    score += DART_SCORES[j];
                    break;
                }
            }
        }
        return score;
    }
}
