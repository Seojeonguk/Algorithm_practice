import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int cardCnt = Integer.parseInt(br.readLine());
            int[] cards = new int[cardCnt];

            StringTokenizer cardInfo = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < cardCnt; idx++) {
                cards[idx] = Integer.parseInt(cardInfo.nextToken());
            }

            int minChangedCardCnt = cardCnt - 1;
            for (int i = 0; i < cardCnt; i++) {
                for (int j = i + 1; j < cardCnt; j++) {
                    if ((cards[j] - cards[i]) % (j - i) > 0) {
                        continue;
                    }

                    int changedCardCnt = 0;
                    int gradient = (cards[j] - cards[i]) / (j - i);
                    int constant = cards[j] - gradient * j;
                    for (int k = 0; k < cardCnt; k++) {
                        int y = gradient * k + constant;
                        if (y != cards[k]) {
                            changedCardCnt++;
                        }
                    }

                    minChangedCardCnt = Math.min(minChangedCardCnt, changedCardCnt);
                }
            }

            sb.append(minChangedCardCnt);

            bw.write(sb.toString());
        }
    }
}
