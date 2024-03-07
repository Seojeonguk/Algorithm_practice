import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_TURN_CNT = 2;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int boardCnt = Integer.parseInt(br.readLine());
        int[] moves = new int[boardCnt];
        StringTokenizer moveInfo = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < boardCnt; idx++) {
            moves[idx] = Integer.parseInt(moveInfo.nextToken());
        }
        int[][] dp = new int[boardCnt][3];
        for (int i = 0; i < boardCnt; i++) {
            Arrays.fill(dp[i], -1);
        }
        int maxTime = calMaxTime(boardCnt, moves, dp, 0, MAX_TURN_CNT, true);
        sb.append(maxTime < 0 ? -1 : maxTime);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calMaxTime(int boardCnt, int[] moves, int[][] dp, int idx, int possibleTurnCnt, boolean isFrontDirection) {
        if (idx < 0 || idx >= boardCnt) {
            return Integer.MIN_VALUE;
        }
        if (idx == boardCnt - 1) {
            return 0;
        }
        if (dp[idx][possibleTurnCnt] != -1) {
            return dp[idx][possibleTurnCnt];
        }

        dp[idx][possibleTurnCnt] = -1000000000;
        dp[idx][possibleTurnCnt] = calMaxTime(boardCnt, moves, dp, idx + moves[idx] * (isFrontDirection ? 1 : -1), possibleTurnCnt, isFrontDirection) + 1;
        if (possibleTurnCnt > 0) {
            dp[idx][possibleTurnCnt] = Math.max(dp[idx][possibleTurnCnt], calMaxTime(boardCnt, moves, dp, idx + moves[idx] * (isFrontDirection ? -1 : 1), possibleTurnCnt - 1, !isFrontDirection) + 1);
        }

        return dp[idx][possibleTurnCnt];
    }
}
