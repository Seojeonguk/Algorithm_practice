import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int cardCnt = Integer.parseInt(st.nextToken());
            int commandCnt = Integer.parseInt(st.nextToken());

            int[][] cards = new int[cardCnt][2];
            for (int i = 0; i < cardCnt; i++) {
                StringTokenizer cardToken = new StringTokenizer(br.readLine());
                cards[i][0] = Integer.parseInt(cardToken.nextToken());
                cards[i][1] = Integer.parseInt(cardToken.nextToken());
            }

            int[] status = new int[cardCnt];
            for (int command = 0; command < commandCnt; command++) {
                int flipUnderK = Integer.parseInt(br.readLine());

                for (int i = 0; i < cardCnt; i++) {
                    if (cards[i][status[i]] <= flipUnderK) {
                        status[i] = 1 - status[i];
                    }
                }
            }

            int cardSum = 0;
            for (int i = 0; i < cardCnt; i++) {
                cardSum += cards[i][status[i]];
            }

            sb.append(cardSum);

            bw.write(sb.toString());
        }
    }
}
