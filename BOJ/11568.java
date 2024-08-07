import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int presentedCardCnt = Integer.parseInt(br.readLine());
            int[] presentedCards = new int[presentedCardCnt];
            StringTokenizer cardToken = new StringTokenizer(br.readLine());
            for (int i = 0; i < presentedCardCnt; i++) {
                presentedCards[i] = Integer.parseInt(cardToken.nextToken());
            }

            sb.append(getMaxIncreasingSequenceLength(presentedCards));

            bw.write(sb.toString());
        }
    }

    public static int getMaxIncreasingSequenceLength(int[] presentedCards) {
        int[] dp = new int[presentedCards.length];

        for (int i = 0; i < presentedCards.length; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (presentedCards[i] > presentedCards[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
