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

        StringTokenizer gameInfo = new StringTokenizer(br.readLine());
        int scoreCnt = Integer.parseInt(gameInfo.nextToken());
        int newScore = Integer.parseInt(gameInfo.nextToken());
        int listSize = Integer.parseInt(gameInfo.nextToken());

        int[] scores = new int[scoreCnt + 1];
        int[] ranking = new int[scoreCnt + 1];
        ranking[0] = 1;
        int newScoreIdx = scoreCnt + 1;

        if (scoreCnt > 0) {
            StringTokenizer scoreInfo = new StringTokenizer(br.readLine());
            for (int i = 1; i <= scoreCnt; i++) {
                scores[i] = Integer.parseInt(scoreInfo.nextToken());
                ranking[i] = (scores[i] == scores[i - 1] ? ranking[i - 1] : i);
                if (scores[i] < newScore && newScoreIdx == scoreCnt + 1) {
                    newScoreIdx = i;
                }
            }
        }

        if (newScoreIdx > listSize) {
            sb.append(-1);
        } else {
            sb.append(scores[newScoreIdx - 1] == newScore ? ranking[newScoreIdx - 1] : newScoreIdx);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
