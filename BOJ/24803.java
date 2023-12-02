import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final Victory[] VICTORIES = new Victory[]{
            new Victory("Estate", 2),
            new Victory("Duchy", 5),
            new Victory("Province", 8)
    };

    static final Treasure[] TREASURES = new Treasure[]{
            new Treasure("Gold", 6, 3),
            new Treasure("Silver", 3, 2),
            new Treasure("Copper", 0, 1)
    };

    public static void main(String[] args) throws Exception {
        int[] possessionTreasures = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sumBuyingPower = 0;
        for (int i = 0; i < possessionTreasures.length; i++) {
            sumBuyingPower += TREASURES[i].buyingPower * possessionTreasures[i];
        }

        String canBuyVictoryCardName = "";
        String canBuyTreasureCardName = "";

        for (int i = 0; i < 3; i++) {
            if (sumBuyingPower >= VICTORIES[i].cost) {
                canBuyVictoryCardName = VICTORIES[i].name;
            }
            if (sumBuyingPower >= TREASURES[2 - i].cost) {
                canBuyTreasureCardName = TREASURES[2 - i].name;
            }
        }

        if (!"".equals(canBuyVictoryCardName)) {
            sb.append(canBuyVictoryCardName).append(" or ");
        }
        sb.append(canBuyTreasureCardName);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Victory {
        String name;
        int cost;

        Victory(String name, int cost) {
            this.name = name;
            this.cost = cost;
        }
    }

    static class Treasure {
        String name;
        int cost;
        int buyingPower;

        Treasure(String name, int cost, int buyingPower) {
            this.name = name;
            this.cost = cost;
            this.buyingPower = buyingPower;
        }
    }
}
