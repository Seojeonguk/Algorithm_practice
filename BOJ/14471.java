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

            StringTokenizer st = new StringTokenizer(br.readLine());
            int halfStampCnt = Integer.parseInt(st.nextToken());
            int pointCardCnt = Integer.parseInt(st.nextToken());

            PointCard[] pointCards = new PointCard[pointCardCnt];
            for (int i = 0; i < pointCardCnt; i++) {
                StringTokenizer pointCardToken = new StringTokenizer(br.readLine());
                int prize = Integer.parseInt(pointCardToken.nextToken());
                int noWay = Integer.parseInt(pointCardToken.nextToken());

                pointCards[i] = new PointCard(prize, noWay);
            }

            int minCostRequiredObtainPrize = getMinCostRequiredObtainPrize(pointCards, halfStampCnt);
            sb.append(minCostRequiredObtainPrize);

            Arrays.sort(pointCards, (o1, o2) -> Integer.compare(o2.prize, o1.prize));

            bw.write(sb.toString());
        }
    }

    public static int getMinCostRequiredObtainPrize(PointCard[] pointCards, int minRequiredPrize) {
        int minCostRequiredObtainPrize = 0;

        Arrays.sort(pointCards, (o1, o2) -> Integer.compare(o2.prize, o1.prize));
        for (int i = 0; i < pointCards.length - 1; i++) {
            if (pointCards[i].prize < minRequiredPrize) {
                minCostRequiredObtainPrize += minRequiredPrize - pointCards[i].prize;
            }
        }

        return minCostRequiredObtainPrize;
    }

    public static class PointCard {
        int prize;
        int noWay;

        PointCard(int prize, int noway) {
            this.prize = prize;
            this.noWay = noway;
        }
    }
}
