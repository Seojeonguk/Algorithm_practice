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

        Loop1:
        while (true) {
            String[][] cardPiles = new String[13][4];
            for (int i = 0; i < 4; i++) {
                StringTokenizer cards = new StringTokenizer(br.readLine());
                for (int j = 0; j < 13; j++) {
                    String card = cards.nextToken();
                    if ("#".equals(card)) {
                        break Loop1;
                    }
                    cardPiles[j][i] = card;
                }
            }

            int flipCnt = 0;
            int[] flips = new int[13];
            int curCard = 0;
            String last = "";

            while (flipCnt < 4 * 13) {
                if (flips[curCard] == 4) {
                    break;
                }
                last = cardPiles[curCard][flips[curCard]];
                int nextCard = getIdx(last.charAt(0));

                flips[curCard]++;
                curCard = nextCard;
                flipCnt++;
            }

            sb.append(String.format("%02d,%s\n", flipCnt, last));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getIdx(char c) {
        int idx = 12;
        if (Character.isDigit(c)) {
            idx -= c - '1';
        } else if (c == 'A') {
            idx -= 0;
        } else if (c == 'T') {
            idx -= 9;
        } else if (c == 'J') {
            idx -= 10;
        } else if (c == 'Q') {
            idx -= 11;
        } else if (c == 'K') {
            idx -= 12;
        }

        return idx;
    }
}
