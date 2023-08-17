import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int CARD_DIGITS = 16;

    public static void main(String[] args) throws Exception {
        String cardNumber = br.readLine();

        int[] cardNum = new int[CARD_DIGITS];
        int cardSumOfDigit = 0;
        for (int idx = 0; idx < CARD_DIGITS; idx++) {
            cardNum[idx] = Integer.parseInt(cardNumber.substring(idx, idx + 1));
            if (idx % 2 == 0) {
                cardNum[idx] *= 2;
            }
            if (cardNum[idx] >= 10) {
                cardNum[idx] = cardNum[idx] / 10 + cardNum[idx] % 10;
            }
            cardSumOfDigit += cardNum[idx];
        }

        sb.append(cardSumOfDigit % 10 == 0 ? "DA" : "NE");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
