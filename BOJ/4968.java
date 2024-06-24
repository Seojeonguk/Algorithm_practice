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

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int HanakoCardCnt = Integer.parseInt(st.nextToken());
                int TaroCardCnt = Integer.parseInt(st.nextToken());

                if (HanakoCardCnt == 0 && TaroCardCnt == 0) {
                    break;
                }

                int[] HanakoCards = new int[HanakoCardCnt];
                int[] TaroCards = new int[TaroCardCnt];

                for (int i = 0; i < HanakoCardCnt; i++) {
                    HanakoCards[i] = Integer.parseInt(br.readLine());
                }

                for (int i = 0; i < TaroCardCnt; i++) {
                    TaroCards[i] = Integer.parseInt(br.readLine());
                }

                int[] equalExchangeCard = getEqualExchangeCard(HanakoCards, TaroCards);
                for (int card : equalExchangeCard) {
                    sb.append(card).append(" ");
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int[] getEqualExchangeCard(int[] a, int[] b) {
        int minCardSum = Integer.MAX_VALUE;

        int[] ret = new int[]{-1};

        int aSum = Arrays.stream(a).sum();
        int bSum = Arrays.stream(b).sum();

        for (int aCard : a) {
            for (int bCard : b) {
                int aSumTemp = aSum - aCard + bCard;
                int bSumTemp = bSum - bCard + aCard;

                if (aSumTemp == bSumTemp) {
                    if (minCardSum > aCard + bCard) {
                        minCardSum = aCard + bCard;
                        ret = new int[]{aCard, bCard};
                    }
                }
            }
        }

        return ret;
    }
}
