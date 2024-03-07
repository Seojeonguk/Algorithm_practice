import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int scoreCnt = Integer.parseInt(br.readLine());
        int[] scores = new int[scoreCnt + 2];
        StringTokenizer scoreInfo = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < scoreCnt; idx++) {
            scores[idx] = Integer.parseInt(scoreInfo.nextToken());
        }

        int[] dp = new int[scoreCnt];
        for (int idx = 0; idx < dp.length; idx++) {
            dp[idx] = Integer.MIN_VALUE;
        }
        int maxScore = calMaxScore(dp, scoreCnt, scores, 0);
        sb.append(maxScore);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calMaxScore(int[] dp, int scoreCnt, int[] scores, int idx) {
        if (scoreCnt <= idx) {
            return 0;
        }

        if (dp[idx] != Integer.MIN_VALUE) {
            return dp[idx];
        }

        int score = Integer.MIN_VALUE;
        score = Math.max(score, calMaxScore(dp, scoreCnt, scores, idx + 1) + scores[idx]);
        score = Math.max(score, calMaxScore(dp, scoreCnt, scores, idx + 3) + (scores[idx] + scores[idx + 1] + scores[idx + 2]) * 2);

        return dp[idx] = score;
    }
}
