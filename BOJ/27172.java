import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int playerCnt = Integer.parseInt(br.readLine());
        int[] playerCards = new int[playerCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxCard = -1;
        for (int i = 0; i < playerCnt; i++) {
            playerCards[i] = Integer.parseInt(st.nextToken());
            maxCard = Math.max(maxCard, playerCards[i]);
        }

        int[] cardIndexes = new int[maxCard + 1];
        Arrays.fill(cardIndexes, -1);

        for (int i = 0; i < playerCnt; i++) {
            cardIndexes[playerCards[i]] = i;
        }

        int[] playerScores = new int[playerCnt];
        for (int i = 0; i < playerCnt; i++) {
            int playerCard = playerCards[i];
            for (int j = playerCard + playerCard; j <= maxCard; j += playerCard) {
                if (cardIndexes[j] != -1) {
                    int secondPlayer = cardIndexes[j];
                    playerScores[secondPlayer]--;
                    playerScores[i]++;
                }
            }
        }

        for (int i = 0; i < playerCnt; i++) {
            sb.append(playerScores[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
