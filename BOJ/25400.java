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

        int cardCnt = Integer.parseInt(br.readLine());
        int[] cards = new int[cardCnt];
        StringTokenizer cardInfo = new StringTokenizer(br.readLine());
        int findCardNum = 1;
        int removeCardCnt = 0;
        for (int cardNum = 0; cardNum < cardCnt; cardNum++) {
            cards[cardNum] = Integer.parseInt(cardInfo.nextToken());
            if (cards[cardNum] == findCardNum) {
                findCardNum++;
            } else {
                removeCardCnt++;
            }
        }

        sb.append(removeCardCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
