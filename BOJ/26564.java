import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            String[] cards = br.readLine().split(" ");
            Arrays.sort(cards);
            int handStrength = 0;
            int sameCard = 0;
            for (int i = 0; i < cards.length; i++) {
                if (i == 0 || cards[i].charAt(0) != cards[i - 1].charAt(0)) {
                    sameCard = 1;
                } else {
                    sameCard++;
                }
                handStrength = Math.max(handStrength, sameCard);
            }
            sb.append(handStrength).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
