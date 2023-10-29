import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MAX_CARD = 13;
    final static int CARD_CATEGORY = 4;

    public static void main(String[] args) throws Exception {
        boolean[][] isFind = new boolean[CARD_CATEGORY][MAX_CARD + 1];

        for (int i = 0; i < 51; i++) {
            st = new StringTokenizer(br.readLine());
            char card = st.nextToken().charAt(0);
            int cardNum = Integer.parseInt(st.nextToken());
            int cardIndex = getCardIndex(card);

            isFind[cardIndex][cardNum] = true;
        }

        Loop1:
        for (int cardIdx = 0; cardIdx < CARD_CATEGORY; cardIdx++) {
            for (int cardNum = 1; cardNum <= MAX_CARD; cardNum++) {
                if (!isFind[cardIdx][cardNum]) {
                    char card = getCard(cardIdx);
                    sb.append(card).append(" ").append(cardNum);
                    break Loop1;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getCardIndex(char card) {
        int cardIdx = -1;
        if (card == 'S') {
            cardIdx = 0;
        } else if (card == 'B') {
            cardIdx = 1;
        } else if (card == 'V') {
            cardIdx = 2;
        } else if (card == 'K') {
            cardIdx = 3;
        }

        return cardIdx;
    }

    public static char getCard(int cardIdx) {
        char card = 0;
        if (cardIdx == 0) {
            card = 'S';
        } else if (cardIdx == 1) {
            card = 'B';
        } else if (cardIdx == 2) {
            card = 'V';
        } else if (cardIdx == 3) {
            card = 'K';
        }
        return card;
    }
}
