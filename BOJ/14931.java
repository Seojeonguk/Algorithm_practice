import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int riverWidth = Integer.parseInt(br.readLine());
            long[] scores = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            Answer answer = getMaxScore(scores);
            sb.append(answer.makeMaxScoreD).append(" ").append(answer.maxScore);

            bw.write(sb.toString());
        }
    }

    public static Answer getMaxScore(long[] scores) {
        int makeMaxScoreD = 0;
        long maxScore = 0;

        for (int d = 1; d <= scores.length; d++) {
            long score = 0;
            for (int idx = d - 1; idx < scores.length; idx += d) {
                score += scores[idx];
            }

            if (maxScore < score) {
                maxScore = score;
                makeMaxScoreD = d;
            }
        }

        return new Answer(makeMaxScoreD, maxScore);
    }

    public static class Answer {
        int makeMaxScoreD;
        long maxScore;

        public Answer(int makeMaxScoreD, long maxScore) {
            this.makeMaxScoreD = makeMaxScoreD;
            this.maxScore = maxScore;
        }
    }
}
