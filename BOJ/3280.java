import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

public class Main {

    static final Map<String, Integer> COLUMNS = Map.of(
            "first", 0,
            "second", 1,
            "third", 2
    );

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cardCnt = Integer.parseInt(br.readLine());
        int[] appearedCard = new int[cardCnt + 1];

        int[] cards = new int[cardCnt];
        for (int cardNum = 0; cardNum < cards.length; cardNum++) {
            cards[cardNum] = cardNum + 1;
        }

        int dealingCnt = Integer.parseInt(br.readLine());
        for (int dealingNum = 0; dealingNum < dealingCnt; dealingNum++) {
            String halsAnswer = br.readLine();
            int column = COLUMNS.get(halsAnswer);

            for (int i = 0; i < cardCnt / 3; i++) {
                appearedCard[cards[i * 3 + column]]++;
            }

            cards = retrieveCards(cards);
        }

        for (int cardNum = 1; cardNum <= cardCnt; cardNum++) {
            if (appearedCard[cardNum] == dealingCnt) {
                sb.append(cardNum).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] retrieveCards(int[] cards) {
        int[] nextCards = new int[cards.length];
        for (int row = 0; row < cards.length / 3; row++) {
            for (int col = 0; col < 3; col++) {
                nextCards[col * cards.length / 3 + row] = cards[row * 3 + col];
            }
        }

        return nextCards;
    }
}
