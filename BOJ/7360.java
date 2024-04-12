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

        while (true) {
            int totalRound = Integer.parseInt(br.readLine());
            if (totalRound == 0) {
                break;
            }

            int[][] players = new int[totalRound][2];

            StringTokenizer aPlayerInfo = new StringTokenizer(br.readLine());
            StringTokenizer bPlayerInfo = new StringTokenizer(br.readLine());

            int aScore = 0, bScore = 0;

            for (int i = 0; i < totalRound; i++) {
                players[i][0] = Integer.parseInt(aPlayerInfo.nextToken());
                players[i][1] = Integer.parseInt(bPlayerInfo.nextToken());

                if (Math.abs(players[i][0] - players[i][1]) == 1) {
                    int addedScore = (Math.min(players[i][0], players[i][1]) == 1 ? 6 : players[i][0] + players[i][1]);
                    if (players[i][0] < players[i][1]) {
                        aScore += addedScore;
                    } else if (players[i][0] > players[i][1]) {
                        bScore += addedScore;
                    }
                } else {
                    if (players[i][0] > players[i][1]) {
                        aScore += players[i][0];
                    } else if (players[i][0] < players[i][1]) {
                        bScore += players[i][1];
                    }
                }
            }

            sb.append(String.format("A has %d points. B has %d points.\n\n", aScore, bScore));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
