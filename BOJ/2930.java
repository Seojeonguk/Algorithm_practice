import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int totalRound = Integer.parseInt(br.readLine());
        char[] myShapes = br.readLine().toCharArray();

        int totalFriend = Integer.parseInt(br.readLine());
        int[][] appearedCnt = new int[totalRound][3];
        for (int friendNum = 0; friendNum < totalFriend; friendNum++) {
            char[] friendShapes = br.readLine().toCharArray();
            for (int round = 0; round < totalRound; round++) {
                int idx = convertShapeToIdx(friendShapes[round]);
                appearedCnt[round][idx]++;
            }
        }

        int myScore = calScore(myShapes, appearedCnt);
        int maxScore = predictMaxScore(appearedCnt);

        sb.append(myScore).append("\n").append(maxScore);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calScore(char[] myShapes, int[][] appearedCnt) {
        int score = 0;

        for (int round = 0; round < myShapes.length; round++) {
            int idx = convertShapeToIdx(myShapes[round]);

            score += appearedCnt[round][(idx + 1) % 3] * 2 + appearedCnt[round][idx];
        }

        return score;
    }

    public static int convertShapeToIdx(char c) {
        int idx = -1;
        if (c == 'S') {
            idx = 0;
        } else if (c == 'P') {
            idx = 1;
        } else if (c == 'R') {
            idx = 2;
        }

        return idx;
    }

    public static int predictMaxScore(int[][] appearedCnt) {
        int maxScore = 0;

        for (int round = 0; round < appearedCnt.length; round++) {
            int maxRoundScore = 0;
            for (int j = 0; j < 3; j++) {
                int score = appearedCnt[round][(j + 1) % 3] * 2 + appearedCnt[round][j];
                maxRoundScore = Math.max(maxRoundScore, score);
            }
            maxScore += maxRoundScore;
        }

        return maxScore;
    }
}
